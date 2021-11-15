package by.htp.netcracker.foodfactory.Controllers;


import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {

    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;

    public PublicRestApiController(UserRepository userRepository, OrdersRepository ordersRepository) {
        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("orders")
    public List<Orders> orders(){
        return ordersRepository.findAll();
    }

    @GetMapping("users")
    public List<User> users(){
        return userRepository.findAll();
    }
}
