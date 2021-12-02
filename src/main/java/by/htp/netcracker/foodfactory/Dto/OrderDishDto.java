package by.htp.netcracker.foodfactory.Dto;

import java.util.Objects;

public class OrderDishDto {

    private int countOfDishes;
    private Integer dish;


    public OrderDishDto(){

    }

    public int getCountOfDishes() {
        return countOfDishes;
    }

    public void setCountOfDishes(int countOfDishes) {
        this.countOfDishes = countOfDishes;
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
        this.dish = dish;
    }

}
