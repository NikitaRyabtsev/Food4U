package by.htp.netcracker.foodfactory.Dto;

import by.htp.netcracker.foodfactory.Model.DishIngredient;

import java.util.List;

public class DishIngredientDto {

    private double weight;
    private Integer ingredient;

    public DishIngredientDto(){

    }
    public DishIngredientDto(double weight, Integer ingredient) {
        this.weight = weight;
        this.ingredient = ingredient;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getIngredient() {
        return ingredient;
    }

    public void setIngredient(Integer ingredient) {
        this.ingredient = ingredient;
    }
}
