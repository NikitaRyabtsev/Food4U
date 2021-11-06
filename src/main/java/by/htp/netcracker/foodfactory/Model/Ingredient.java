package by.htp.netcracker.foodfactory.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private double calories;
    @Column
    private double weight;
    @Column
    private double proteins;
    @Column
    private double fats;
    @Column
    private double carbohydrates;
    @ManyToMany
    @JoinTable(name="dish_has_ingredient",
            joinColumns = @JoinColumn(name="ingredient_id"),
            inverseJoinColumns = @JoinColumn(name="dish_id"))
    private List<Dish> dishes;

    public Ingredient(Integer id, String name, double calories, double weight, double proteins, double fats, double carbohydrates, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.dishes = dishes;
    }

    public Ingredient() {

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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.calories, calories) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.proteins, proteins) == 0 &&
                Double.compare(that.fats, fats) == 0 &&
                Double.compare(that.carbohydrates, carbohydrates) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(dishes, that.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, weight, proteins, fats, carbohydrates, dishes);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", weight=" + weight +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", dishes=" + dishes +
                '}';
    }
}
