package by.htp.netcracker.foodfactory.RestControllers;


import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.cloudinary.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/order")
public class OrderRestController {

    private final DishRepository dishRepository;
    private final OrdersRepository orderRepository;
    private final IngredientRepository ingredientRepository;
    private final OrderService orderService;
    private final OrderDishesRepository orderDishesRepository;

    public OrderRestController(OrdersRepository orderRepository, DishRepository dishRepository,
                               IngredientRepository ingredientRepository, OrderService orderService, OrderDishesRepository userDishesRepository) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
        this.ingredientRepository = ingredientRepository;
        this.orderService = orderService;
        this.orderDishesRepository = userDishesRepository;
    }

    @PostMapping(name="/newOrder", produces = "application/json")
    public@ResponseBody OrderDish addOrdersDish(@RequestBody OrderDish orderDish){
        return orderDishesRepository.save(orderDish);
    }

}
