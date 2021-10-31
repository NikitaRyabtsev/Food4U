package by.htp.netcracker.foodfactory.Model;

import java.util.Objects;

public class Ingredient {

    private int id;
    private String name;
    private double calories;
    private double weight;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public Ingredient(int id, String name, double calories, double weight, double proteins, double fats, double carbohydrates) {
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
        return id == that.id &&
                Double.compare(that.calories, calories) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.proteins, proteins) == 0 &&
                Double.compare(that.fats, fats) == 0 &&
                Double.compare(that.carbohydrates, carbohydrates) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, weight, proteins, fats, carbohydrates);
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
                '}';
    }
}
