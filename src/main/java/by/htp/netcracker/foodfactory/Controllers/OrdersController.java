package by.htp.netcracker.foodfactory.Controllers;


import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrdersController {

//    private DishRepository dishRepository;
    private OrdersRepository orderRepository;
//    private IngredientRepository ingredientRepository;

    public OrdersController(OrdersRepository orderRepository) {
//        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
//        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("ordersInfo", orderRepository.findAll());
        return "order/orders";
    }

//    @GetMapping("/newOrder")
//    public String newOrder(Model model) {
//        model.addAttribute("order", new Order());
//        model.addAttribute("dishes", dishRepository.findAll());
//        return "order/newOrder";
//    }
//
//    @PostMapping("/newOrder")
//    public String addDishInOrder(@ModelAttribute("order") Order order) {
//        orderRepository.save(order);
//        return "redirect:menu/dishes";
//    }
//
//    @GetMapping("/{id}/order")
//    public String getDishWithIngredientById(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("dishes", orderRepository.getById(id));
//        model.addAttribute("dishes", dishRepository.findAll());
//        model.addAttribute("ingredients", ingredientRepository.findAll());
//        return "order/order";
//    }
//
//    @PostMapping("/{id}/order")
//    public String deleteDish(@PathVariable("id") Integer id) {
//        orderRepository.deleteById(id);
//        return "redirect:/menu/dishes";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editDish(Model model, @PathVariable("id") Integer id) {
//        model.addAttribute("order", orderRepository.getById(id));
//        model.addAttribute("dishes", dishRepository.findAll());
//        model.addAttribute("ingredients", ingredientRepository.findAll());
//        return "menu/dishEdit";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String updateDish(@ModelAttribute("order") Order order) {
//        orderRepository.save(order);
//        return "redirect:/menu/dishes";
//    }

}
