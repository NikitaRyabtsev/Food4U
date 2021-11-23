package by.htp.netcracker.foodfactory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    private double calories;
    private double weight;
    @Column
    private double proteins;
    @Column
    private double fats;
    @Column
    private double carbohydrates;
    @OneToMany(mappedBy = "ingredient" , fetch = FetchType.LAZY)
    private List<DishIngredient> ingredientsDish;


    public Ingredient(Integer id, String name, double calories, double weight, double proteins, double fats, double carbohydrates, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Ingredient() {

    }

    public List<DishIngredient> getIngredientsDish() {
        return ingredientsDish;
    }

    public void setIngredientsDish(List<DishIngredient> ingredientsDish) {
        this.ingredientsDish = ingredientsDish;
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

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.calories, calories) == 0 && Double.compare(that.weight, weight) == 0 && Double.compare(that.proteins, proteins) == 0 && Double.compare(that.fats, fats) == 0 && Double.compare(that.carbohydrates, carbohydrates) == 0 && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(ingredientsDish, that.ingredientsDish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, weight, proteins, fats, carbohydrates, ingredientsDish);
    }
}
