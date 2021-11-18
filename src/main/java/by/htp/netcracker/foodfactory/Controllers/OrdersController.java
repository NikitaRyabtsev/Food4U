package by.htp.netcracker.foodfactory.Controllers;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import by.htp.netcracker.foodfactory.Service.DishService;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.exceptions.TemplateProcessingException;

import javax.transaction.Transactional;
import java.security.Principal;

@Controller
@RequestMapping("/order")
public class OrdersController{

    private final DishRepository dishRepository;
    private final OrdersRepository orderRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;
    private final DishService dishService;



    public OrdersController(OrdersRepository orderRepository, DishRepository dishRepository,
                            IngredientRepository ingredientRepository,OrderService orderService ,
                            UserRepository userRepository,DishService dishService) {
            this.dishRepository = dishRepository;
            this.orderRepository = orderRepository;
            this.ingredientRepository = ingredientRepository;
            this.orderService = orderService;
            this.userRepository = userRepository;
            this.dishService = dishService;

        }

        @GetMapping("/orders")
        public String showOrders (Model model , Principal principal){
            model.addAttribute("orders",orderService.findOrdersByUserName(principal.getName()));
            model.addAttribute("dishes", dishRepository.findAll());
            model.addAttribute("ingredients", ingredientRepository.findAll());
            return "order/orders";
        }

        @GetMapping("/newOrder")
        public String newOrder (Principal principal, Model model){
            model.addAttribute("order", new Orders());
            model.addAttribute("dishes", dishService.findDishesSortByType());
            model.addAttribute("ingredients", dishRepository.findAll());
            model.addAttribute("username", orderService.findOrderByUserName(principal.getName()));
            return "order/newOrder";
        }

        @PreAuthorize("hasAnyRole('USER','ADMIN')")
        @PostMapping("/newOrder")
        public String addOrder (@ModelAttribute("order")Orders order , Principal principal){
         orderService.saveOrderByUser(principal.getName(), order);
         return "redirect:/order/newOrder";
        }

        @GetMapping("/{id}/order")
        public String getDishWithIngredientById (@PathVariable("id") Integer id, Model model){
            model.addAttribute("order", orderRepository.getById(id));
            model.addAttribute("dishes", dishRepository.findAll());
            model.addAttribute("ingredients", ingredientRepository.findAll());
            return "order/order";
        }
        @Transactional
        @PostMapping("/delete/{idDish}")
        public String deleteDishFromOrder (@PathVariable("idDish") Integer id){
            orderRepository.deleteDishFromOrderById(id);
            return "redirect:/order/orders";
        }

        @GetMapping("/editOrder")
        public String editOrder (Model model, Principal principal){
            model.addAttribute("dishes", dishRepository.findAll());
            model.addAttribute("order" , orderService.findOrderByUserName(principal.getName()));
            return "order/editOrder";
        }

        @PostMapping("/editOrder")
        public String updateOrder (@ModelAttribute("order") Orders order, Principal principal){
            orderService.saveOrderByUser(principal.getName(), order);
            return "redirect:/order/userOrder";
        }

        @PreAuthorize("hasAnyRole('USER','ADMIN')")
        @GetMapping("/userOrder")
        public String findUserOrder(Model model , Principal principal){
            model.addAttribute("dishes", dishRepository.findAll());
            model.addAttribute("ingredients", ingredientRepository.findAll());
            model.addAttribute("order",orderService.findOrderByUserName(principal.getName()));
            if(orderService.findOrderByUserName(principal.getName()) == null){
                return "redirect:/order/newOrder";
            }
            return "/order/order";
        }

}