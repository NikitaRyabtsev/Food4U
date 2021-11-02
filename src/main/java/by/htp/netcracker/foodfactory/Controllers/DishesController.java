package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.DishDao;
import by.htp.netcracker.foodfactory.Dao.impl.DishDaoImpl;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class DishesController {

    DishDao dishDao = new DishDaoImpl();

    @GetMapping("/dishes")
    public String showDishesWithIngredients(Model model) {
        try {
            model.addAttribute("dishes", dishDao.showDishWithIngredients());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "menu/dishes";
    }

    @GetMapping("/newDish")
    public String createDishWithIngredients(Model model) throws DaoException {
        model.addAttribute("dish", new Dish());
        return "menu/newDish";
    }

    @PostMapping("/newDish")
    public String addDishWithIngredients(@ModelAttribute("dish") Dish dish) throws DaoException {
        dishDao.addDishWithIngredients(dish);
        return "redirect:/menu/dishes";
    }


    @GetMapping("/newIngredient")
    public String createIngredientInDish(Model model) throws DaoException {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/newIngredientInDish";
    }

    @PostMapping("/newIngredient")
    public String addIngredientInDish(@ModelAttribute("ingredient") Ingredient ingredient) throws DaoException {
        dishDao.addIngredientsInDish(ingredient);
        return "redirect:/menu/dishes";
    }

    @GetMapping("/{id}/dish")
    public String getDishWithIngredientById(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("dishes", dishDao.showDishWithIngredientsById(id));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "menu/dishes";
    }

    @PostMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id") int id) {
        try {
            dishDao.deleteDishWithIngredients(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "redirect:/menu/dishes";
    }

    @GetMapping("/isAvailable")
    public String isAvailable(Model model) {
        try {
            model.addAttribute("dishes", dishDao.isDishesWithIngredientsAvailable());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "menu/dishesAvailable";
    }

    @GetMapping("/{id}/edit")
    public String editDish(Model model, @PathVariable("id") int id) {
        try {
            model.addAttribute("dish", dishDao.showDishWithIngredientsById(id));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "menu/dishEdit";

    }

    @PostMapping("/{id}/edit")
    public String updateDish(@ModelAttribute("dish") Dish dish) {
        try {
            dishDao.updateDishWithIngredients(dish);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "redirect:/menu/dishes";
    }

    @GetMapping("/main")
    public String isAva(Model model) {
        try {
            model.addAttribute("dishes", dishDao.isDishesWithIngredientsAvailable());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "viewhtml/main";
    }
}
