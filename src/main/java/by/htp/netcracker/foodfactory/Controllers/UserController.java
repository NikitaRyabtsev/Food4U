package by.htp.netcracker.foodfactory.Controllers;


import by.htp.netcracker.foodfactory.Dao.DaoException;
import by.htp.netcracker.foodfactory.Dao.UserDao;
import by.htp.netcracker.foodfactory.Dao.impl.UserDaoImpl;
import by.htp.netcracker.foodfactory.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    UserDao userDao = new UserDaoImpl();

    @GetMapping
    public String showUsers(Model model) {
        try {
            model.addAttribute("users", userDao.getAllUsers());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "user/users";
    }

    @GetMapping("/registration")
    public String addUser(Model model)throws DaoException{
        model.addAttribute("user" , new User());
        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user")User user) throws DaoException {
        userDao.registration(user);
        return "redirect:/user/authorization";
    }

    @GetMapping("/authorization/{login}/{password}")
    public String authorization(@PathVariable("login") String login ,@PathVariable("password") String password , Model model){
        return "/user/authorization";
    }

    @PostMapping("authorization/{login}/{password}")
    public String logOn(@PathVariable("login") String login ,@PathVariable("password") String password){
        try {
            userDao.authorization(login, password);
        }catch(DaoException e){
            e.printStackTrace();
        }
        return "user/authorizaiton";
    }

    @GetMapping("edit/{id}")
    public String editProfile(@PathVariable("id")int id,Model model) {
        try {
            model.addAttribute("id", userDao.toEditProfile(id));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "user/profile";
    }

    @PostMapping("edit/{id}")
    public String updateProfile(@ModelAttribute("user") User user){
        try {
            userDao.editUserProfile(user);
        }catch (DaoException e){
            e.printStackTrace();
        }
        return "user/profile";
    }
}
