package by.htp.netcracker.foodfactory.Dao.impl;

import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.DishDao;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import by.htp.netcracker.foodfactory.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DishDaoImpl implements DishDao {
    IngredientDaoImpl ingredientDao = new IngredientDaoImpl();
    public static int DISH_COUNT;
    private final List<Dish> dishes;
    private final Map<Dish, List<Ingredient>> dishMap;

    {
        dishes = new ArrayList<>();
        dishes.add(new Dish(++DISH_COUNT, "Жаркое", Type.SEAFOOD.toString(), 100, 150, 200, true));
        dishes.add(new Dish(++DISH_COUNT, "Борщ", Type.DRINK.toString(), 130, 350, 200, true));
        dishes.add(new Dish(++DISH_COUNT, "Бутерброд", Type.SNACK.toString(), 20, 70, 300, true));
        dishes.add(new Dish(++DISH_COUNT, "Блинчики", Type.SEAFOOD.toString(), 1000, 10, 250, false));
        dishes.add(new Dish(++DISH_COUNT, "Торт", Type.SEAFOOD.toString(), 130, 60, 100, true));
        dishes.add(new Dish(++DISH_COUNT, "Компот",Type.SEAFOOD.toString(), 100, 150, 250, false));
    }

    {
        dishMap = new ConcurrentHashMap<>();

        dishMap.put(dishes.get(0), ingredientDao.getIngredients());
        dishMap.put(dishes.get(1), ingredientDao.getIngredients());
        dishMap.put(dishes.get(3), ingredientDao.getIngredients());
        dishMap.put(dishes.get(4), ingredientDao.getIngredients());
        dishMap.put(dishes.get(5), ingredientDao.getIngredients());
    }


    @Override
    public Map<Dish, List<Ingredient>> showDishWithIngredients() throws DaoException {
        return dishMap;
    }

    @Override
    public void addDishWithIngredients(Dish dish) throws DaoException {
        dish.setId(DISH_COUNT++);
        dishMap.put(dish, ingredientDao.getIngredients());
    }

    @Override
    public void addIngredientsInDish(Ingredient ingredient) throws DaoException {
        for (int i = 0; i < dishes.size(); i++) {
            dishMap.put(dishes.get(i), init(ingredient));
        }
    }

    @Override
    public Map.Entry<Dish, List<Ingredient>> showDishWithIngredientsById(int id) throws DaoException {
        for (Map.Entry<Dish, List<Ingredient>> key : dishMap.entrySet()) {
            if (key.getKey().getId() == id) {
                return key;
            }
        }
        return null;
    }

    @Override
    public void deleteDishWithIngredients(int id) throws DaoException {
        if (id == 0) {
            throw new NullPointerException("DishID is not specified");
        }
        for (Dish dish : dishMap.keySet()) {
            if (dish.getId() == id) {
                dishMap.remove(dish);
            }
        }
    }

    @Override
    public Map<Dish, List<Ingredient>> isDishesWithIngredientsAvailable() throws DaoException {
        for (Dish dish : dishMap.keySet()) {
            if (dish.isAvailable() == true) {
                return dishMap;
            }
        }
        return null;
    }

    @Override
    public void updateDishWithIngredients(Dish dish) throws DaoException {
        for (Dish dishes : dishMap.keySet()) {
            if (dishes.getId() == dish.getId()) {
                dishMap.remove(dish);
                dishMap.put(dish,ingredientDao.getIngredients());
            }
        }
    }


    public List<Ingredient> init(Ingredient ingredient) {
        List<Ingredient> ingredientList = ingredientDao.getIngredients();

        ingredient.setId(IngredientDaoImpl.INGREDIENT_COUNT++);
        ingredientList.add(ingredient);
        return ingredientList;
    }

}
