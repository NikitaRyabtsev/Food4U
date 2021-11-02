package by.htp.netcracker.foodfactory.Dao.impl;

import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.UserDao;;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Role;
import by.htp.netcracker.foodfactory.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public static int USER_COUNT;
    private final List<User> users;


    {
        users = new ArrayList<>();
        users.add(new User(USER_COUNT++ , Role.ADMIN.toString(),"Anton","admin","admin","123anton@mail.ru","Kulakovich","male", LocalDate.of(2000,12,13), Status.UNBLOCK.toString()));
        users.add(new User(USER_COUNT++ , Role.USER.toString(),"Artyom","123","123","123artyom@mail.ru","Gevondyan","male", LocalDate.of(2001,3,23),Status.UNBLOCK.toString()));
        users.add(new User(USER_COUNT++ , Role.USER.toString(),"Nikita","1234","1234","123nikita@mail.ru","Ryabtsev","male", LocalDate.of(2000,10,07),Status.UNBLOCK.toString()));
    }
    @Override
    public void registration(User user) throws DaoException {
        user.setId(USER_COUNT++);
        users.add(user);
    }

    @Override
    public User authorization(String login, String password) throws DaoException {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return users;
    }

    @Override
    public void editUserProfile(User user) throws DaoException {
        for(int i =0 ;i < users.size(); i++){
            if(users.get(i).getId() == user.getId()){
                users.set(i,user);
            }
        }

    }

    @Override
    public User toEditProfile(int id) throws DaoException {
        for(int i = 0 ; i < users.size();i++){
            if(users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteUser(int id) throws DaoException {
        for(int i = 0 ; i < users.size();i++){
            if(users.get(i).getId() == id){
                users.remove(i);
            }
        }

    }
    @Override
    public void blockUser(int id) throws DaoException {

    }
}
