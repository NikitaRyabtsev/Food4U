package by.htp.netcracker.foodfactory.Controllers;


import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrdersController {

    private DishRepository dishRepository;
    private OrdersRepository orderRepository;
    private IngredientRepository ingredientRepository;
    private OrderService orderService;

    public OrdersController(OrdersRepository orderRepository , DishRepository dishRepository ,
                            OrderService orderService, IngredientRepository ingredientRepository ) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
        this.ingredientRepository = ingredientRepository;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("dishes",dishRepository.findAll());
        model.addAttribute("ingredients",ingredientRepository.findAll());
        return "order/orders";
    }

    @GetMapping("/newOrder")
    public String newOrder(Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("ingredients",dishRepository.findAll());
        return "order/newOrder";
    }

    @PostMapping("/newOrder")
    public String addDishInOrder(@ModelAttribute("order") Orders orders) {
        orderRepository.save(orders);
        return "redirect:/order/newOrder";
    }

    @GetMapping("/{id}/order")
    public String getDishWithIngredientById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", orderRepository.getById(id));
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "order/order";
    }

    @PostMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id") Integer id) {
        orderRepository.deleteById(id);
        return "redirect:/order/orders";
    }

    @PostMapping("/{dish}/deleteDishFromOrder")
    public String deleteDishFromOrder(@ModelAttribute("dish") Dish dish){
        orderService.deleteDishFromOrder(dish);
        return "redirect:/order/orders";
    }

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
