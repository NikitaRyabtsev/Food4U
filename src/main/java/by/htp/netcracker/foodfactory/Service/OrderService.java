package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Helper.OrderStatus;
import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;
    private final OrderDishesRepository orderDishesRepository;

    public OrderService(UserRepository userRepository, OrdersRepository ordersRepository, OrderDishesRepository userDishesRepository) {
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
        orders.setUser(user);
        if(!Objects.equals(orders.getStatus(), OrderStatus.CONSIDERED.toString()) ||
                !Objects.equals(orders.getStatus(), OrderStatus.DONE.toString())){
            ordersRepository.findByUser(user);
            ordersRepository.save(orders);
        }
        orderDishesRepository.save(new OrderDish());
        return orders;
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
