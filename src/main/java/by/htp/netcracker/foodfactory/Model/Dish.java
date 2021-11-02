package by.htp.netcracker.foodfactory.Model;

import java.util.Objects;

public class Dish {


    private int id;
    private String name;
    private String type;
    private double price;
    private double calories;
    private double weight;
    private boolean isAvailable;

    public Dish(int id, String name, String type, double price, double calories, double weight, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.calories = calories;
        this.weight = weight;
        this.isAvailable = isAvailable;
    }

    public Dish() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id &&
                Double.compare(dish.price, price) == 0 &&
                Double.compare(dish.calories, calories) == 0 &&
                Double.compare(dish.weight, weight) == 0 &&
                isAvailable == dish.isAvailable &&
                Objects.equals(name, dish.name) &&
                Objects.equals(type, dish.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, calories, weight, isAvailable);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                ", weight=" + weight +
                ", isAvailable=" + isAvailable +
                '}';
    }
}


