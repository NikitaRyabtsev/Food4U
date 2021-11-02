package by.htp.netcracker.foodfactory.Dao.impl;
import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.DishDao;
import by.htp.netcracker.foodfactory.Dao.IngredientDao;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Ingredient;

import java.util.*;

public class IngredientDaoImpl implements IngredientDao {

    public static int INGREDIENT_COUNT;
    private final List<Ingredient> ingredients;

    {
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Мука",100,100,0.1,3.2,35));
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Мак",105,100,3,4.6,51));
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Лук",100,100,0.2,0,13));
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Филе куриное",100,100,12,4,35));
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Хлеб",100,100,0.1,4,70));
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Яйцо",100,100,6,4.2,32));
        ingredients.add(new Ingredient(++INGREDIENT_COUNT,"Молоко",170,100,3.4,6.5,33));
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public List<Ingredient> showIngredients() throws DaoException {
        return ingredients;
    }


    @Override
    public Ingredient showIngredientById(int id) throws DaoException {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getId() == id) {
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public void deleteIngredient(int id) throws DaoException {
        if (id == 0) {
            throw new NullPointerException("DishID is not specified");
        }
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getId() == id) {
                ingredients.remove(i);
            }
        }
    }

    @Override
    public void addIngredient(Ingredient ingredient) throws DaoException {
        ingredient.setId(INGREDIENT_COUNT++);
        ingredients.add(ingredient);
    }

    @Override
    public void updateIngredient(Ingredient ingredient) throws DaoException {
        for(int i = 0 ; i< ingredients.size(); i ++){
            if(ingredients.get(i).getId() == ingredient.getId()){
                ingredients.set(i,ingredient);
            }
        }
    }
}
