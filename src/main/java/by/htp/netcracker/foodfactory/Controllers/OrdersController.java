package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.OrdersDish;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.*;
import by.htp.netcracker.foodfactory.Service.DishService;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.security.Principal;

@Controller
@Scope("session")
@RequestMapping("/order")
public class OrdersController {

    private final DishRepository dishRepository;
    private final OrdersRepository orderRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;
    private final DishService dishService;
    private final OrdersDishesRepository ordersDishesRepository;


    public OrdersController(OrdersRepository orderRepository, DishRepository dishRepository,
                            IngredientRepository ingredientRepository, OrderService orderService,
                            UserRepository userRepository, DishService dishService, OrdersDishesRepository ordersDishesRepository) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
        this.ingredientRepository = ingredientRepository;
        this.orderService = orderService;
        this.userRepository = userRepository;
        this.dishService = dishService;
        this.ordersDishesRepository = ordersDishesRepository;

    }

    @GetMapping("/orders")
    public String showOrders(Model model, Principal principal) {
        model.addAttribute("orders", orderService.findOrdersByUserName(principal.getName()));
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "order/orders";
    }

    @GetMapping("/newOrderTest")
    public String newTestOrder(Principal principal, Model model , HttpSession session) {
        session.setAttribute("order", new Orders());
        model.addAttribute("order_dishes" , new OrdersDish());
        model.addAttribute("dishes" , dishRepository.findAll());
        model.addAttribute("username" , orderService.findOrderByUserName(principal.getName()));
        return "order/newOrderTest";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/newOrderTest")
    public String addTestOrder(@ModelAttribute("order_dishes")OrdersDish ordersDish){
        ordersDishesRepository.save(ordersDish);
        return "redirect:/order/newOrderTest";
    }

    @GetMapping("/newOrder")
    public String newOrder(Principal principal, Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("dishes", dishService.findDishesSortByType());
        model.addAttribute("ingredients", dishRepository.findAll());
        model.addAttribute("username", orderService.findOrderByUserName(principal.getName()));
        model.addAttribute("orders_dish", ordersDishesRepository.findAll());
        return "order/newOrder";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/newOrder")
    public String addOrder(@ModelAttribute("order") Orders order, Principal principal) {
        orderService.saveOrderByUser(principal.getName(), order);
        return "redirect:/order/newOrder";
    }

    @GetMapping("/{id}/order")
    public String getDishWithIngredientById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", orderRepository.getById(id));
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "order/order";
    }

    @Transactional
    @PostMapping("/delete/{idDish}")
    public String deleteDishFromOrder(@PathVariable("idDish") Integer id) {
        orderRepository.deleteDishFromOrderById(id);
        return "redirect:/order/userOrder";
    }

    @GetMapping("/{id}/editOrder")
    public String editOrder(Model model, Principal principal, @PathVariable("id") Integer id) {
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("order", orderService.findOrderByUserNameAndId(principal.getName(), id));
        return "order/editOrder";
    }

    @PostMapping("/{id}/editOrder")
    public String updateOrder(@ModelAttribute("order") Orders order, Principal principal) {
        orderService.saveOrderByUser(principal.getName(), order);
        return "redirect:/order/userOrder";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/userOrder")
    public String findUserOrder(Model model, Principal principal) {
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("order", orderService.findOrderByUserName(principal.getName()));
        if (orderService.findOrderByUserName(principal.getName()) == null) {
            return "redirect:/order/newOrder";
        }
        return "/order/order";
    }

}