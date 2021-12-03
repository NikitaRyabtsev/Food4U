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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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
        List<Orders> orders = ordersRepository.findAllByUser(user,Sort.by(Sort.Direction.DESC, "dateTimeOfBooking"));
        return orders;
    }

    public void saveOrderWithOrderDish(OrderDishDto orderDishDto, String username) {
        User user = userRepository.getUserByUsername(username);
        Orders checkOrders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        if (checkOrders != null) {
            OrderDish orderDish = orderDishesRepository.findByOrderAndDish(checkOrders, dishRepository.getById(orderDishDto.getDish()));
            if (orderDish != null) {
                orderDish.setCountOfDishes(orderDish.getCountOfDishes() + orderDishDto.getCountOfDishes());
                orderDishesRepository.save(orderDish);
            }else{
                orderDish = new OrderDish();
                orderDish.setDish(dishRepository.getById(orderDishDto.getDish()));
                orderDish.setCountOfDishes(orderDishDto.getCountOfDishes());
                orderDish.setOrder(findActiveOrder(user.getUsername()));
                orderDishesRepository.save(orderDish);
            }
        }else{
            Orders orders = new Orders();
            orders.setNumberOfBooking(MathRandom.generateNumberOfBooking());
            orders.setUser(user);
            orders.setStatus(OrderStatus.CONSIDERED.toString());
            OrderDish orderDish = new OrderDish();
            orderDish.setDish(dishRepository.getById(orderDishDto.getDish()));
            orderDish.setCountOfDishes(orderDishDto.getCountOfDishes());
            orderDish.setOrder(orders);
            orderDishesRepository.save(orderDish);
            ordersRepository.save(orders);
        }
    }

        public Orders findActiveOrder (String username){
            User user = userRepository.getUserByUsername(username);
            Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
            return orders;
        }

        public void saveActiveOrder (String username, OrderDishDto orderDishDto){
            User user = userRepository.getUserByUsername(username);
            double counter = 0;
            if (user != null) {
                Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
                List<OrderDish> orderDishes = orderDishesRepository.findAllByOrder(orders);
                for (int i = 0; i < orderDishes.size(); i++) {
                    orderDishes.get(i).setCountOfDishes(orderDishDto.getCountOfDishes());
                    int countOfDishes = orderDishes.get(i).getCountOfDishes();
                    double price = orderDishes.get(i).getDish().getPrice().doubleValue();
                    counter += countOfDishes*price;
                }
                if (orders != null) {
                    orders.setPrice(BigDecimal.valueOf(counter));
                    orders.setDateTimeOfBooking(LocalDateTime.now());
                    orders.setStatus(OrderStatus.FORMALIZED.toString());
                    ordersRepository.save(orders);
                }
            }
        }

        public void confirmOrder (Integer id){
            Orders orders = ordersRepository.findOrdersById(id);
            orders.setStatus(OrderStatus.DONE.toString());
            ordersRepository.save(orders);
        }


        public List<Orders> showOrdersOrderByDateAndTime(){
            return ordersRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTimeOfBooking"));
        }
    }
