package by.htp.netcracker.foodfactory.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    private Integer id;
    @Column
    private int numberOfOrder;
    @Column
    private LocalDateTime dateAndTimeOfOrder;
    @Column
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToMany
    @JoinTable(name="order_has_dish",
            joinColumns = @JoinColumn(name="Order_id"),
            inverseJoinColumns = @JoinColumn(name="dish_id"))
    private List<Dish> dishes;


    public Order(){

    }
    public Order(Integer id, int numberOfOrder, LocalDateTime dateAndTimeOfOrder, String status, User user) {
        this.id = id;
        this.numberOfOrder = numberOfOrder;
        this.dateAndTimeOfOrder = dateAndTimeOfOrder;
        this.status = status;
        this.user = user;
    }

    public Order(Integer id, int numberOfOrder, LocalDateTime dateAndTimeOfOrder, String status, User user, List<Dish> dishes) {
        this.id = id;
        this.numberOfOrder = numberOfOrder;
        this.dateAndTimeOfOrder = dateAndTimeOfOrder;
        this.status = status;
        this.user = user;
        this.dishes = dishes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public LocalDateTime getDateAndTimeOfOrder() {
        return dateAndTimeOfOrder;
    }

    public void setDateAndTimeOfOrder(LocalDateTime dateAndTimeOfOrder) {
        this.dateAndTimeOfOrder = dateAndTimeOfOrder;
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
        Order order = (Order) o;
        return numberOfOrder == order.numberOfOrder &&
                Objects.equals(id, order.id) &&
                Objects.equals(dateAndTimeOfOrder, order.dateAndTimeOfOrder) &&
                Objects.equals(status, order.status) &&
                Objects.equals(user, order.user) &&
                Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfOrder, dateAndTimeOfOrder, status, user, dishes);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", numberOfOrder=" + numberOfOrder +
                ", dateAndTimeOfOrder=" + dateAndTimeOfOrder +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", dishes=" + dishes +
                '}';
    }
}

