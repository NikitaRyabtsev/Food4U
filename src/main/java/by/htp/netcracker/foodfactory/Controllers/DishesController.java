package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Dto.DishIngredientDto;
import by.htp.netcracker.foodfactory.Model.Dish;

import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Reposotories.DishIngredientsRepository;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Service.DishService;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class DishesController {

    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
    private final OrdersRepository ordersRepository;
    private final DishService dishService;
    private final DishIngredientsRepository dishIngredientsRepository;
    private final OrderService orderService;

    public DishesController(DishRepository dishRepository,
                            IngredientRepository ingredientRepository, OrdersRepository ordersRepository ,
                            DishService dishService , DishIngredientsRepository dishIngredientsRepository ,
                            OrderService orderService) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.ordersRepository = ordersRepository;
        this.dishService = dishService;
        this.dishIngredientsRepository = dishIngredientsRepository;
        this.orderService = orderService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/dishes")
    public String showDishesWithIngredients(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("orders" , ordersRepository.findAll());
        return "menu/dishes";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/newDish")
    public String createDishWithIngredients(Model model) {
        model.addAttribute("dish", new Dish());
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        return "menu/newDish";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}/dish")
    public String getDishWithIngredientById(@PathVariable("id") Integer id, Model model , Principal principal) {
        Orders orders = orderService.findActiveOrder(principal.getName());
        if(orders == null){
            model.addAttribute("order", new Orders());
        }else{
            model.addAttribute("order", orders);
        }
        model.addAttribute("dishes", dishRepository.getById(id));
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        return "menu/dish";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{id}/delete")
    @Transactional
    public String deleteDish(@PathVariable("id") Integer id) {
        dishIngredientsRepository.deleteByDishId(id);
        dishRepository.deleteById(id);
        return "redirect:/menu/dishes";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{id}/edit")
    public String editDish(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("dish", dishRepository.getById(id));
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        return "menu/dishEdit";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{id}/edit")
    public String updateDish(@ModelAttribute("dish") Dish dish) {
        dishRepository.save(dish);
        return "redirect:/menu/dishes";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("dishes/{type}")
    public String showDishByType(Model model, @PathVariable("type") String type , Principal principal){
        model.addAttribute("dishes",dishRepository.getDishByType(type));
        Orders orders = orderService.findActiveOrder(principal.getName());
        if(orders == null){
            model.addAttribute("order", new Orders());
        }else{
            model.addAttribute("order", orders);
        }
        return "menu/dishesType";
    }
}

