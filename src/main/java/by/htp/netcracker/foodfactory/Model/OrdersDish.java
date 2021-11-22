package by.htp.netcracker.foodfactory.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "orders_dish")
@Entity
public class OrdersDish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int countOfDishes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public OrdersDish() {
    }
    public OrdersDish(Integer id, int countOfDishes, Orders orders, Dish dish) {
        this.id = id;
        this.countOfDishes = countOfDishes;
        this.orders = orders;
        this.dish = dish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCountOfDishes() {
        return countOfDishes;
    }

    public void setCountOfDishes(int countOfDishes) {
        this.countOfDishes = countOfDishes;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDish that = (OrdersDish) o;
        return countOfDishes == that.countOfDishes && Objects.equals(id, that.id) && Objects.equals(orders, that.orders) && Objects.equals(dish, that.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countOfDishes, orders, dish);
    }

}
