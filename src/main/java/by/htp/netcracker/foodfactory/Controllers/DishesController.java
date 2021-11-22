package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.Dish;

import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import by.htp.netcracker.foodfactory.Reposotories.DishIngredientsRepository;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Service.DishService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class DishesController {

    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
    private final OrdersRepository ordersRepository;
    private final DishService dishService;
    private final DishIngredientsRepository dishIngredientsRepository;

    public DishesController(DishRepository dishRepository,
                            IngredientRepository ingredientRepository, OrdersRepository ordersRepository ,
                            DishService dishService , DishIngredientsRepository dishIngredientsRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.ordersRepository = ordersRepository;
        this.dishService = dishService;
        this.dishIngredientsRepository = dishIngredientsRepository;
    }

    @GetMapping("/dishes")
    public String showDishesWithIngredients(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("orders" , ordersRepository.findAll());
        return "menu/dishes";
    }


    @GetMapping("/newDish")
    public String createDishWithIngredients(Model model) {
        model.addAttribute("dish_ingredient" , new DishIngredient());
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        model.addAttribute("dishes" , dishRepository.findAll());
        model.addAttribute("dish_ingredients", dishIngredientsRepository.findAll());

        return "menu/newDish";
    }

    @PostMapping("/newDish")
    public String addDishWithIngredients(@ModelAttribute("dish_ingredient") DishIngredient dishIngredient)  {
        dishIngredientsRepository.save(dishIngredient);
        return "redirect:/menu/dishes";
    }

    @GetMapping("/{id}/dish")
    public String getDishWithIngredientById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dishes", dishRepository.getById(id));
        model.addAttribute("ingredients" , ingredientRepository.findAll());
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

