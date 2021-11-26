package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/users";
    }

    @GetMapping("/registration")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user)  {
        userRepository.save(user);
        return "redirect:/menu/dishes";
    }

    @GetMapping("/profile")
    public String toUserProfile(Model model , Principal principal){
        model.addAttribute("user",userRepository.getUserByUsername(principal.getName()));
        return "user/profile";
    }

    @GetMapping("edit/{id}")
    public String editProfile(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userRepository.getById(id));
        return "user/editProfile";
    }

    @PostMapping("edit/{id}")
    public String updateProfile(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/user/profile";
    }

}
