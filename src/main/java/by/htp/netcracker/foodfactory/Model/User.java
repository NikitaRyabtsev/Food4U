package by.htp.netcracker.foodfactory.Model;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private int id;
    private String role;
    private String name;
    private String login;
    private String password;
    private String email;
    private String surname;
    private String sex;
    private LocalDate dateOfBirth;
    private String block;

    public User(int id, String role, String name, String login, String password, String email, String surname, String sex, LocalDate dateOfBirth, String block) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.block = block;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(role, user.role) &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(block, user.block);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, name, login, password, email, surname, sex, dateOfBirth, block);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", block='" + block + '\'' +
                '}';
    }
}
