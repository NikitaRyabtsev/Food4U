package by.htp.netcracker.foodfactory.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Dish")

public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private double price;
    @Column
    private double weight;
    @Column
    private double calories;
    @Lob
    @Column
    private String src;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="dish_has_ingredient",
                joinColumns = @JoinColumn(name="dish_id"),
                inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name="order_has_dish",
                joinColumns = @JoinColumn(name="dish_id"),
                inverseJoinColumns = @JoinColumn(name="order_id"))
    private List<Orders> orders;

    public Dish(){

    }
    public Dish(Integer id, String name, String type, double price, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.ingredients = ingredients;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 &&
                Objects.equals(id, dish.id) &&
                Objects.equals(name, dish.name) &&
                Objects.equals(type, dish.type) &&
                Objects.equals(ingredients, dish.ingredients);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, ingredients);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", src='" + src + '\'' +
                ", ingredients=" + ingredients +
                ", orders=" + orders +
                '}';
    }
}


