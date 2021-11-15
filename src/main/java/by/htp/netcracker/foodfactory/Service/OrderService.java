package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;

    public OrderService(UserRepository userRepository, OrdersRepository ordersRepository) {
        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
    }

    public Orders findOrderByUserName(String username){
        User user = userRepository.getUserByUsername(username);
        return ordersRepository.findOrdersByUser(user);
    }
}
