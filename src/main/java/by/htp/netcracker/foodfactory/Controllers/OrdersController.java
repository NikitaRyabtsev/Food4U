package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Helper.MathRandom;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {

    private final DishRepository dishRepository;
    private final OrdersRepository orderRepository;
    private final IngredientRepository ingredientRepository;
    private final OrderService orderService;
    private final OrderDishesRepository orderDishesRepository;

    public OrdersController(OrdersRepository orderRepository, DishRepository dishRepository,
                            IngredientRepository ingredientRepository, OrderService orderService, OrderDishesRepository userDishesRepository) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
        this.ingredientRepository = ingredientRepository;
        this.orderService = orderService;
        this.orderDishesRepository = userDishesRepository;

    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "order/orders";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{id}/confirmOrder")
    public String confirmOrder(@PathVariable("id") Integer id) {
        orderService.confirmOrder(id);
        return "redirect:/order/orders";
    }

    @GetMapping("/newOrder")
    public String newOrder(Model model, Principal principal) {
        model.addAttribute("dishes", dishRepository.findAll());
        Orders orders = orderService.findActiveOrder(principal.getName());
        if(orders == null){
            model.addAttribute("order", new Orders());
        }else{
            model.addAttribute("order", orders);
        }
        return "order/newOrder";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/userOrder")
    public String findUserOrder(Model model, Principal principal) {
        Orders orders = orderService.findActiveOrder(principal.getName());
        if(orders == null){
            return "redirect:/order/newOrder";
        }else{
            model.addAttribute("order", orders);
        }
        return "/order/order";
    }

    @Transactional
    @PostMapping("/{id}/delete")
    public String deleteDishFromUserDish(@PathVariable("id") Integer id) {
        orderDishesRepository.deleteByDishId(id);
        return "redirect:/order/userOrder";
    }

    @GetMapping("/ordersHistory")
    public String findOrdersByUser(Model model, Principal principal) {
        List<Orders> orders = orderService.findOrdersByUser(principal.getName());
        model.addAttribute("orders", orders);
        return "order/ordersHistory";
    }

}