package by.htp.netcracker.foodfactory.Model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private double price;

    @Lob
    @Column
    private String src;
    @ManyToMany
    @JoinTable(name="dish_has_ingredient",
                joinColumns = @JoinColumn(name="dish_id"),
                inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredients;
//
//    @ManyToMany
//    @JoinTable(name="order_has_dish",
//                joinColumns = @JoinColumn(name="dish_id"),
//                inverseJoinColumns = @JoinColumn(name="Order_id"))
//    private List<OrderInfo> orders;

    public Dish(){

    }
    public Dish(Integer id, String name, String type, double price, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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
                ", ingredients=" + ingredients +
                '}';
    }
}


