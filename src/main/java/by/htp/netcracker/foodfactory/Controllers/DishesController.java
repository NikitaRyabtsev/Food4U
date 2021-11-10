package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.Dish;

import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/menu")
public class DishesController {

    private DishRepository dishRepository;
    private IngredientRepository ingredientRepository;

    public DishesController(DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }
    @GetMapping("/main")
    public String toMainPage() {
        return "viewhtml/main";
    }

    @GetMapping("/dishes")
    public String showDishesWithIngredients(Model model , HttpServletRequest request) {
        System.out.println("Username" + request.getSession().getAttribute("username"));
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
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
