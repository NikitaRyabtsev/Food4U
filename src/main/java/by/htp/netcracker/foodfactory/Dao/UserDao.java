package by.htp.netcracker.foodfactory.Dao;

import by.htp.netcracker.foodfactory.Model.User;

import java.util.List;

public interface UserDao {

    void registration(User user) throws DaoException;

    User authorization(String login, String password) throws DaoException;

    List<User> getAllUsers() throws DaoException;

    void editUserProfile(User user) throws DaoException;

    User toEditProfile(int id) throws DaoException;

    void deleteUser(int id) throws DaoException;

    void blockUser(int id) throws DaoException;

}
