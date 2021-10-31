package by.htp.netcracker.foodfactory.Dao;

import by.htp.netcracker.foodfactory.Model.Ingredient;

import java.util.List;

public interface IngredientDao {

    List<Ingredient> showIngredients() throws DaoException;

    void addIngredientInDish(Ingredient ingredient) throws DaoException;

    void deleteIngredientFromDish(int id) throws DaoException;

    Ingredient showIngredientById(int id) throws DaoException;

    //Админ
    void deleteIngredient(int id) throws DaoException;

    void addIngredient(Ingredient ingredient) throws DaoException;

    void updateIngredient(Ingredient ingredient) throws DaoException;


}
