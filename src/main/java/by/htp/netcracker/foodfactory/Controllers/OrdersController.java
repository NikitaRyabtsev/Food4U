package by.htp.netcracker.foodfactory.Controllers;

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
        model.addAttribute("orders", orderService.showOrdersOrderByDateAndTime());
        return "order/orders";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{id}/confirmOrder")
    public String confirmOrder(@PathVariable("id") Integer id) {
        orderService.confirmOrderByAdmin(id);
        return "redirect:/order/orders";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
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

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/userOrder")
    public String saveActiveOrder(@ModelAttribute("order")Orders order , Principal principal){
        orderService.saveActiveOrder(order , principal.getName());
        return "redirect:/order/newOrder";
    }


    @Transactional
    @PostMapping("/{id}/delete")
    public String deleteDishFromOrder(@PathVariable("id") Integer id , Principal principal) {
        orderService.deleteDishFromOrder(id , principal.getName());
        return "redirect:/order/userOrder";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/ordersHistory")
    public String findOrdersByUser(Model model, Principal principal) {
        List<Orders> orders = orderService.findOrdersByUser(principal.getName());
        model.addAttribute("orders", orders);
        return "order/ordersHistory";
    }

}