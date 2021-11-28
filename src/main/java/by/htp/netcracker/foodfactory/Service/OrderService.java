package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

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

    public OrderDish saveOrderDishByOrder(String username, OrderDish orderDish) {
        User user = userRepository.getUserByUsername(username);
        orderDish.setUser(user);
        return orderDishesRepository.save(orderDish);
    }

    public List<Orders> findOrdersByUser(String username) {
        User user = userRepository.getUserByUsername(username);
        List<Orders> orders = ordersRepository.findAllByUser(user);
        return orders;
    }

    public Orders saveOrderByUser(String username, Orders orders) {
        User user = userRepository.getUserByUsername(username);
        orders.setUser(user);
        return ordersRepository.save(orders);
    }


    public List<OrderDish> findUserDishesByUser(String username) {
        User user = userRepository.getUserByUsername(username);
        List<OrderDish> orderDishes = orderDishesRepository.findAllByUser(user);
        return orderDishes ;
    }
}
