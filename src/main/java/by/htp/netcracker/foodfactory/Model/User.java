package by.htp.netcracker.foodfactory.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String role;
    @Column
    private String name;
    @Size(min = 8,max = 16)
    @Column
    private String username;
    @Size(min = 8,max = 16)
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String surname;
    @Column
    private String sex;
    @Column
    private String block;
    @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
    private List<Orders> orders;


    public User(Integer id, String role, String name, String login, String password, String email, String surname, String sex, String block) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.username = login;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.sex = sex;
        this.block = block;
    }

    public User() {

    }

    public User(String role, String name, String login, String password, String email, String surname, String sex, String block) {
        this.role = role;
        this.name = name;
        this.username = login;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.sex = sex;
        this.block = block;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public List<String> getRolesList(){
        if(!role.isEmpty()){
            return Arrays.asList(role.split(","));
        }
        return new ArrayList<>();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(role, user.role) &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(block, user.block);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, name, username, password, email, surname, sex, block);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", block='" + block + '\'' +
                '}';
    }
}
