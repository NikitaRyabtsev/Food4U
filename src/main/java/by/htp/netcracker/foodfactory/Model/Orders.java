package by.htp.netcracker.foodfactory.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Column
    private LocalDateTime dateTimeOfBooking;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user")
    private User user;

    public Orders(){
    }

    public Orders(Integer id, String status, double numberOfBooking, LocalDateTime dateTimeOfBooking, User user) {
        this.id = id;
        this.status = status;
        this.numberOfBooking = numberOfBooking;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.user = user;
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

