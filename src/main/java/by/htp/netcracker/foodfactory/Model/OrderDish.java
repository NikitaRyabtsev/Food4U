package by.htp.netcracker.foodfactory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "order_dish")
@Entity
public class OrderDish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int countOfDishes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Orders order;

    public OrderDish() {
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
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
        OrderDish userDish = (OrderDish) o;
        return countOfDishes == userDish.countOfDishes && Objects.equals(id, userDish.id) && Objects.equals(dish, userDish.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countOfDishes, dish, order);
    }
}
