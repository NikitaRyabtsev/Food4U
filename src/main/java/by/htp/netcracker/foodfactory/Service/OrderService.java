package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Dto.OrderDishDto;
import by.htp.netcracker.foodfactory.Helper.MathRandom;
import by.htp.netcracker.foodfactory.Helper.OrderStatus;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import by.htp.netcracker.foodfactory.RestControllers.OrderRestController;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;
    private final OrderDishesRepository orderDishesRepository;
    private final DishRepository dishRepository;

    public OrderService(UserRepository userRepository, OrdersRepository ordersRepository,
                        OrderDishesRepository userDishesRepository, DishRepository dishRepository) {
        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
        this.orderDishesRepository = userDishesRepository;
        this.dishRepository = dishRepository;
    }

    public List<Orders> findOrdersByUser(String username) {
        User user = userRepository.getUserByUsername(username);
        List<Orders> orders = ordersRepository.findAllByUser(user);
        return orders;
    }

    public void saveOrderWithOrderDish(OrderDishDto orderDishDto, String username) {
        User user = userRepository.getUserByUsername(username);
        if (user != null) {
            Orders checkOrders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
            if (checkOrders != null) {
                OrderDish orderDish = orderDishesRepository.findByOrderAndDish
                        (checkOrders, dishRepository.getById(orderDishDto.getDish()));
                if (orderDish != null) {
                    orderDish.setCountOfDishes(orderDish.getCountOfDishes() + orderDishDto.getCountOfDishes());
                    orderDishesRepository.save(orderDish);
                }
            } else {
                OrderDish orderDish = new OrderDish();
                orderDish.setDish(dishRepository.getById(orderDishDto.getDish()));
                orderDish.setCountOfDishes(orderDishDto.getCountOfDishes());
                orderDish.setOrder(findActiveOrder(user.getUsername()));
                if (findActiveOrder(user.getUsername()) == null) {
                    Orders orders = new Orders();
                    orders.setNumberOfBooking(MathRandom.generateNumberOfBooking());
                    orders.setUser(user);
                    orders.setStatus(OrderStatus.CONSIDERED.toString());
                    orderDish.setOrder(orders);
                }
                orderDishesRepository.save(orderDish);
            }
        }
    }

//    public void countDishesInOrder(String username, Integer id , OrderDishDto orderDishDto) {
//        User user = userRepository.getUserByUsername(username);
//        Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
//        Dish dish = dishRepository.getById(id);
//        OrderDish orderDish = orderDishesRepository.findByOrderAndDish(orders, dish);
//        if (orderDish != null) {
//            orderDish.setCountOfDishes(orderDish.getCountOfDishes() + orderDishDto.getCountOfDishes());
//            orderDishesRepository.save(orderDish);
//        }
//    }

    public Orders findActiveOrder(String username) {
        User user = userRepository.getUserByUsername(username);
        Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        return orders;
    }

    public void saveActiveOrder(String username, OrderDishDto orderDishDto) {
        User user = userRepository.getUserByUsername(username);
        if (user != null) {
            Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
            List<OrderDish> orderDishes = orderDishesRepository.findAllByOrder(orders);
            for (int i = 0; i < orderDishes.size(); i++) {
                orderDishes.get(i).setCountOfDishes(orderDishDto.getCountOfDishes());
            }
            if (orders != null) {
                orders.setDateTimeOfBooking(LocalDateTime.now());
                orders.setStatus(OrderStatus.FORMALIZED.toString());
                ordersRepository.save(orders);
            }
        }
    }
}
