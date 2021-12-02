package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import by.htp.netcracker.foodfactory.Service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
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
        userService.registration(user);
        return "redirect:/menu/dishes";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/profile")
    public String toUserProfile(Model model , Principal principal){
        model.addAttribute("user",userRepository.getUserByUsername(principal.getName()));
        return "user/profile";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("edit/{id}")
    public String editProfile(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userRepository.getById(id));
        return "user/editProfile";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("edit/{id}")
    public String updateProfile(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/user/profile";
    }

}
