package by.htp.netcracker.foodfactory.Dao;

import by.htp.netcracker.foodfactory.Model.Dish;

import java.util.List;

public interface DishDao {


    List<Dish> showDishes() throws DaoException;

    void addMenuElement(Dish dish) throws DaoException;

    void addDish(Dish dish) throws DaoException;

    Dish showDishById(int id) throws DaoException;

    List<Dish> isDishAvailable() throws DaoException;

    void updateDish(Dish dish) throws DaoException;

    void deleteDish(int id) throws DaoException;




}
