package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.DishDao;
import by.htp.netcracker.foodfactory.Dao.impl.DishDaoImpl;
import by.htp.netcracker.foodfactory.Model.Dish;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class DishesController {

    DishDao dishDao = new DishDaoImpl();

    @GetMapping
    public String showAllDishes(Model model) {
        try {
            model.addAttribute("dishes", dishDao.showDishes());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "menu/dishes";
    }

    @GetMapping("/new")
    public String newDish(Model model) throws DaoException{
        model.addAttribute("dish",new Dish());
        return "menu/newDish";
    }

    @PostMapping("/new")
    public String addDish(@ModelAttribute("dish") Dish dish) throws DaoException {
        dishDao.addDish(dish);
        return "redirect:/menu";
    }

    @GetMapping("/isAvailable")
    public String isAvailable(Model model){
        try {
            model.addAttribute("dishes" ,dishDao.isDishAvailable());
        }catch(DaoException e){
            e.printStackTrace();
        }
        return "menu/dishesAvailable";
    }

    @GetMapping("/{id}")
    public String getDishById(@PathVariable("id") int id, Model model){
        try {
            model.addAttribute("dish", dishDao.showDishById(id));
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "menu/dishById";
    }

    @GetMapping("/{id}/edit")
    public String editDish(Model model,@PathVariable("id")int id){
        try {
            model.addAttribute("dish", dishDao.showDishById(id));
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "menu/dishEdit";

    }
    @PostMapping("/{id}/edit")
    public String updateDish(@ModelAttribute("dish")Dish dish){
        try {
            dishDao.updateDish(dish);
        }catch(DaoException e){
            e.printStackTrace();
        }
        return "redirect:/menu";
    }

    @PostMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id")int id){
        try {
            dishDao.deleteDish(id);
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "redirect:/menu";

    }
}
