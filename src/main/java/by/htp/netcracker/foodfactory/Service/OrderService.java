package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Helper.MathRandom;
import by.htp.netcracker.foodfactory.Helper.OrderStatus;
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

    public OrderService(UserRepository userRepository, OrdersRepository ordersRepository,
                        OrderDishesRepository userDishesRepository) {
        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
        this.orderDishesRepository = userDishesRepository;
    }

    public Orders saveOrderByOrder(String username, Orders order) {
        User user = userRepository.getUserByUsername(username);
        order.setUser(user);
        return ordersRepository.save(order);
    }

    public List<Orders> findOrdersByUser(String username) {
        User user = userRepository.getUserByUsername(username);
        List<Orders> orders = ordersRepository.findAllByUser(user);
        return orders;
    }

    public Orders saveOrderByUser(String username, Orders orders) {
        User user = userRepository.getUserByUsername(username);
        OrderDish orderDish = new OrderDish();
        orderDish.setOrder(findActiveOrder(user.getUsername()));
        if (findActiveOrder(user.getUsername()) == null) {
            orderDish.setOrder(orders);
            orders.setNumberOfBooking(MathRandom.generateNumberOfBooking());
            orders.setUser(user);
            orders.setStatus(OrderStatus.CONSIDERED.toString());
        }

        orderDishesRepository.save(orderDish);
        return orders;
    }

    public Orders findActiveOrder(String username) {
        User user = userRepository.getUserByUsername(username);
        Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        return orders;
    }

    public Orders saveActiveOrder(String username , Orders orders){
        User user = userRepository.getUserByUsername(username);
        orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        orders.setDateTimeOfBooking(LocalDateTime.now());
        return ordersRepository.save(orders);
    }
//
//
//    public List<OrderDish> findUserDishesByUser(String username) {
//        User user = userRepository.getUserByUsername(username);
//        List<OrderDish> orderDishes = orderDishesRepository.findAllByUser(user);
//        return orderDishes ;
//    }

//    public Orders saveOrderById(Orders order){
//        Orders order = ordersRepository.getById(id);
//        order.
//        ordersRepository.updateOrderStatusById()
//    }
}
