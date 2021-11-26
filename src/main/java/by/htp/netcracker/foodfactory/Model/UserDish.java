package by.htp.netcracker.foodfactory.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "user_dish")
@Entity
public class UserDish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int countOfDishes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;


    public UserDish() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDish userDish = (UserDish) o;
        return countOfDishes == userDish.countOfDishes && Objects.equals(id, userDish.id) && Objects.equals(dish, userDish.dish) && Objects.equals(user, userDish.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countOfDishes, dish, user);
    }
}
