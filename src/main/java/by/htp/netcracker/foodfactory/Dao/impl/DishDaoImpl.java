package by.htp.netcracker.foodfactory.Dao.impl;

import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.DishDao;
import by.htp.netcracker.foodfactory.Model.Dish;


import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {

    public static int DISH_COUNT;
    private final List<Dish> dishes;

    {
        dishes = new ArrayList<>();
        dishes.add(new Dish(++DISH_COUNT, "Корась", "Рыбный продукт", 100, 150, 200, true));
        dishes.add(new Dish(++DISH_COUNT, "Филе", "Мясной продукт", 130, 350, 200, true));
        dishes.add(new Dish(++DISH_COUNT, "Бутерброд", "Закуска", 20, 70, 300, true));
        dishes.add(new Dish(++DISH_COUNT, "Икра", "Рыбный продукт", 1000, 10, 250, false));
        dishes.add(new Dish(++DISH_COUNT, "Карп", "Рыбный продукт", 130, 60, 100, true));
        dishes.add(new Dish(++DISH_COUNT, "Окунь", "Рыбный продукт", 100, 150, 250, false));

    }

    public List<Dish> showDishes() throws DaoException {
        return dishes;
    }

    @Override
    public void addMenuElement(Dish dish) throws DaoException {
        dish.setId(DISH_COUNT++);
        dish.setId(DISH_COUNT++);
        dishes.add(dish);
    }

    @Override
    public void addDish(Dish dish) throws DaoException {
        dish.setId(DISH_COUNT++);
        dishes.add(dish);
    }

    @Override
    public Dish showDishById(int id) throws DaoException {
        for (Dish dish : dishes) {
            if (dish.getId() == id) {
                return dish;
            }
        }
        return null;
    }

    @Override
    public List<Dish> isDishAvailable() throws DaoException {

        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).isAvailable() == true) {
                return dishes;
            }
        }
        return null;
    }

    @Override
    public void updateDish(Dish dish) throws DaoException {
        for(int i = 0 ; i< dishes.size(); i ++){
            if(dishes.get(i).getId() == dish.getId()){
                dishes.set(i,dish);
                return;
            }
        }
    }

    @Override
    public void deleteDish(int id) throws DaoException {
        if (id == 0) {
            throw new NullPointerException("DishID is not specified");
        }
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getId() == id) {
                dishes.remove(i);
            }
        }


    }
}
