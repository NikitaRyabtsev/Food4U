package by.htp.netcracker.foodfactory.RestControllers;

import by.htp.netcracker.foodfactory.Dto.OrderDishDto;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
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

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @ResponseBody
    @RequestMapping(value = "/newOrder" , method = RequestMethod.POST , produces ="application/json" )
    public String addOrdersDish(@RequestBody OrderDishDto orderDishDto , Principal principal) throws IOException {
        orderService.saveOrderWithOrderDish(orderDishDto,principal.getName());
        return "redirect:/order/newOrder";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @ResponseBody
    @RequestMapping(value = "/updateOrder" , method = RequestMethod.POST , produces ="application/json" )
    public RedirectView updateDishInOrder(@RequestBody OrderDishDto orderDishDto , Principal principal){
        orderService.saveActiveOrder(principal.getName(),orderDishDto);
        return new RedirectView("/order/newOrder");
    }

    @GetMapping("/newOrder")
    public List<OrderDish> addOrdersDish(){
        return orderDishesRepository.findAll();
    }

}
