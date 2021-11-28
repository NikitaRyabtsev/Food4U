package by.htp.netcracker.foodfactory.Model;

import org.springframework.format.annotation.DateTimeFormat;

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
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="status")
    private String status;
    @NotNull
    @Column(name="numberOfBooking" , unique = true)
    private int numberOfBooking;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTimeOfBooking;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDish> orderDishes;

    public Orders(){
    }

    public Orders(Integer id, String status, int numberOfBooking, LocalDateTime dateTimeOfBooking, User user) {
        this.id = id;
        this.status = status;
        this.numberOfBooking = numberOfBooking;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.user = user;
    }

    public List<OrderDish> getOrderDishes() {
        return orderDishes;
    }

    public void setOrderDishes(List<OrderDish> userDishes) {
        this.orderDishes = userDishes;
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

    public int getNumberOfBooking() {
        return numberOfBooking;
    }

    public void setNumberOfBooking(int numberOfBooking) {
        this.numberOfBooking = numberOfBooking;
    }

    public LocalDateTime getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public void setDateTimeOfBooking(LocalDateTime dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
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
        Orders orders = (Orders) o;
        return Double.compare(orders.numberOfBooking, numberOfBooking) == 0 && Objects.equals(id, orders.id) && Objects.equals(status, orders.status) && Objects.equals(dateTimeOfBooking, orders.dateTimeOfBooking) && Objects.equals(user, orders.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, numberOfBooking, dateTimeOfBooking, user);
    }
}

