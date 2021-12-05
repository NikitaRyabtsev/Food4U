package by.htp.netcracker.foodfactory.Dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderDishDto {

    private int countOfDishes;
    private BigDecimal price;
    private Integer dish;


    public OrderDishDto(){

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDish(Integer dish) {
        this.dish = dish;
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
