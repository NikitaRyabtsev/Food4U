package by.htp.netcracker.foodfactory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal price;
    @Lob
    @Column
    private String src;
    private double weight;
    private double calories;
    @JsonIgnore
    @OneToMany(mappedBy = "dish" , cascade = CascadeType.ALL)
    private List<DishIngredient> dish_ingredients;
    @JsonIgnore
    @OneToMany(mappedBy = "dish")
    private List<OrderDish> orders_dishes;

    public Dish() {

    }
    public Dish(Integer id, String name, String type, BigDecimal price, String src, double weight, double calories, List<Ingredient> ingredients, List<OrderDish> orders_dishes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.src = src;
        this.weight = weight;
        this.calories = calories;

    }

    public List<DishIngredient> getDish_ingredients() {
        return dish_ingredients;
    }

    public void setDish_ingredients(List<DishIngredient> dish_ingredients) {
        this.dish_ingredients = dish_ingredients;
    }

    public List<OrderDish> getOrders_dishes() {
        return orders_dishes;
    }

    public void setOrders_dishes(List<OrderDish> orders_dishes) {
        this.orders_dishes = orders_dishes;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.weight, weight) == 0 && Double.compare(dish.calories, calories) == 0 && Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(type, dish.type) && Objects.equals(price, dish.price) && Objects.equals(src, dish.src) && Objects.equals(dish_ingredients, dish.dish_ingredients) && Objects.equals(orders_dishes, dish.orders_dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, src, weight, calories, dish_ingredients, orders_dishes);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", src='" + src + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", dish_ingredients=" + dish_ingredients +
                ", orders_dishes=" + orders_dishes +
                '}';
    }
}


