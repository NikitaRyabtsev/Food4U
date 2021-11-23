package by.htp.netcracker.foodfactory.Dto;

import by.htp.netcracker.foodfactory.Model.DishIngredient;

import java.util.List;

public class DishIngredientDto {

    private List<DishIngredient> dishIngredientList;

    public DishIngredientDto(){

    }

    public void addDishIngredient(DishIngredient dishIngredient){
        this.dishIngredientList.add(dishIngredient);
    }

    public List<DishIngredient> getDishIngredientList() {
        return dishIngredientList;
    }

    public void setDishIngredientList(List<DishIngredient> dishIngredientList) {
        this.dishIngredientList = dishIngredientList;
    }
}
