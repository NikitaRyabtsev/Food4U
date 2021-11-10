package by.htp.netcracker.foodfactory.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="status")
    private String status;
    @Column(name="numberOfBooking")
    private String numberOfBooking;

    public Booking(){

    }

    public Booking(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Booking(Integer id, String status, String numberOfBooking) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(status, booking.status) &&
                Objects.equals(numberOfBooking, booking.numberOfBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, numberOfBooking);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", numberOfBooking='" + numberOfBooking + '\'' +
                '}';
    }
}
