package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;

    public OrderService(UserRepository userRepository, OrdersRepository ordersRepository) {
        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findOrdersByUserName(String username){
        User user = userRepository.getUserByUsername(username);
        List<Orders> orders = ordersRepository.findOrdersByUserOrderById(user);
        return orders;
    }

    public Orders saveOrderByUser(String username, Orders orders){
        User user = userRepository.getUserByUsername(username);
        orders.setUser(user);
        return ordersRepository.save(orders);
    }

    public Orders findOrderByUserNameAndId(String username , Integer id){
        User user = userRepository.getUserByUsername(username);
        Orders order = ordersRepository.findOrdersByUserAndId(user,id);
        return order;
    }

    public Orders findOrderByUserName(String username){
        User user = userRepository.getUserByUsername(username);
        Orders order = ordersRepository.findOrdersByUser(user);
        return order;
    }
}
