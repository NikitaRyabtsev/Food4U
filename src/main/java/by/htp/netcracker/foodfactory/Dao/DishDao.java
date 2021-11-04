package by.htp.netcracker.foodfactory.Dao;

import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Ingredient;

import java.util.List;
import java.util.Map;

public interface DishDao {

    Map<Dish, List<Ingredient>> showDishWithIngredients() throws DaoException;

    void addDishWithIngredients(Dish dish) throws DaoException;

    void addIngredientsInDish(Ingredient ingredient) throws DaoException;

    Map.Entry<Dish, List<Ingredient>> showDishWithIngredientsById(int id) throws DaoException;

    void deleteDishWithIngredients(int id) throws DaoException;

    Map<Dish, List<Ingredient>> isDishesWithIngredientsAvailable() throws DaoException;

    void updateDishWithIngredients(Dish dish) throws DaoException;

}
