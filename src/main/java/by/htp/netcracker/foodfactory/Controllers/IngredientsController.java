package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.IngredientDao;
import by.htp.netcracker.foodfactory.Dao.impl.IngredientDaoImpl;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingredients")
public class IngredientsController {

    IngredientDao ingredientDao = new IngredientDaoImpl();

    @GetMapping
    public String showAllIngredients(Model model) {
        try {
            model.addAttribute("ingredients", ingredientDao.showIngredients());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ingredients/ingredients";
    }

    @GetMapping("/new")
    public String newIngredient(Model model) throws DaoException{
        model.addAttribute("ingredient",new Ingredient());
        return "ingredients/newIngredient";
    }

    @PostMapping("/new")
    public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient) throws DaoException {
        ingredientDao.addIngredient(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping("/{id}")
    public String getIngredientById(@PathVariable("id") int id, Model model){
        try {
            model.addAttribute("ingredient", ingredientDao.showIngredientById(id));
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "ingredients/ingredientById";
    }

    @GetMapping("/{id}/edit")
    public String editIngredient(Model model,@PathVariable("id")int id){
        try {
            model.addAttribute("ingredient", ingredientDao.showIngredientById(id));
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "ingredients/ingredientEdit";

    }
    @PostMapping("/{id}/edit")
    public String updateDish(@ModelAttribute("ingredient") Ingredient ingredient){
        try {
            ingredientDao.updateIngredient(ingredient);
        }catch(DaoException e){
            e.printStackTrace();
        }
        return "redirect:/ingredients";
    }

    @PostMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id")int id){
        try {
            ingredientDao.deleteIngredient(id);
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "redirect:/ingredients";
    }



}
