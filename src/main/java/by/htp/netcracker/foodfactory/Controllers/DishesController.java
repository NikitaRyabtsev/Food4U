package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.Dish;

import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class DishesController {

    private DishRepository dishRepository;
    private IngredientRepository ingredientRepository;
    private OrdersRepository ordersRepository;

    public DishesController(DishRepository dishRepository,
                            IngredientRepository ingredientRepository, OrdersRepository ordersRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("/dishes")
    public String showDishesWithIngredients(Model model) {
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("orders" , ordersRepository.findAll());
        return "menu/dishes";
    }

    @GetMapping("/newDish")
    public String createDishWithIngredients(Model model) {
        model.addAttribute("dish", new Dish());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "menu/newDish";
    }

    @PostMapping("/newDish")
    public String addDishWithIngredients(@ModelAttribute("dish") Dish dish) {
        dishRepository.save(dish);
        return "redirect:/menu/dishes";
    }

    @GetMapping("/{id}/dish")
    public String getDishWithIngredientById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dishes", dishRepository.getById(id));
        return "menu/dish";
    }


    @PostMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id") Integer id) {
        dishRepository.deleteById(id);
        return "redirect:/menu/dishes";
    }

    @GetMapping("/{id}/edit")
    public String editDish(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("dish", dishRepository.getById(id));
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        return "menu/dishEdit";
    }

    @PostMapping("/{id}/edit")
    public String updateDish(@ModelAttribute("dish") Dish dish) {
        dishRepository.save(dish);
        return "redirect:/menu/dishes";
    }

    @GetMapping("dishes/{type}")
    public String showDishByType(Model model, @PathVariable("type") String type){
        model.addAttribute("dishes",dishRepository.getDishByType(type));
        return "menu/dishesType";
    }
}

