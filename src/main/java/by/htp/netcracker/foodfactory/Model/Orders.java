package by.htp.netcracker.foodfactory.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="status")
    private String status;
    @Column(name="numberOfBooking")
    private String numberOfBooking;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToMany
    @JoinTable(name="order_has_dish",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="dish_id"))
    private List<Dish> dishes;

    public Orders(){

    }

    public Orders(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Orders(Integer id, String status, String numberOfBooking) {
        this.id = id;
        this.status = status;
        this.numberOfBooking = numberOfBooking;
    }

    public Integer getId() {
        return id;
    }

    public String getNumberOfBooking() {
        return numberOfBooking;
    }

    public void setNumberOfBooking(String numberOfBooking) {
        this.numberOfBooking = numberOfBooking;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) &&
                Objects.equals(status, orders.status) &&
                Objects.equals(numberOfBooking, orders.numberOfBooking) &&
                Objects.equals(user, orders.user) &&
                Objects.equals(dishes, orders.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, numberOfBooking, user, dishes);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", numberOfBooking='" + numberOfBooking + '\'' +
                ", user=" + user +
                ", dishes=" + dishes +
                '}';
    }
}
