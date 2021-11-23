package by.htp.netcracker.foodfactory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="status")
    private String status;
    @NotNull
    @Column(name="numberOfBooking")
    private double numberOfBooking;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "orders" , fetch = FetchType.EAGER)
    private List<OrdersDish> orders_dishes;

    public Orders(){
    }

    public Orders(Integer id, String status, double numberOfBooking, User user, List<OrdersDish> orders_dishes) {
        this.id = id;
        this.status = status;
        this.numberOfBooking = numberOfBooking;
        this.user = user;
        this.orders_dishes = orders_dishes;
    }

    public Integer getId() {
        return id;
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

    public double getNumberOfBooking() {
        return numberOfBooking;
    }

    public void setNumberOfBooking(double numberOfBooking) {
        this.numberOfBooking = numberOfBooking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrdersDish> getOrders_dishes() {
        return orders_dishes;
    }

    public void setOrders_dishes(List<OrdersDish> orders_dishes) {
        this.orders_dishes = orders_dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Double.compare(orders.numberOfBooking, numberOfBooking) == 0 && Objects.equals(id, orders.id) && Objects.equals(status, orders.status) && Objects.equals(user, orders.user) && Objects.equals(orders_dishes, orders.orders_dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, numberOfBooking, user, orders_dishes);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", numberOfBooking=" + numberOfBooking +
                ", user=" + user +
                ", orders_dishes=" + orders_dishes +
                '}';
    }
}
