package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final DishRepository dishRepository;

    public HomeController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/main")
    public String toMainPage(Model model){
        model.addAttribute("dishes" , dishRepository.findTheMostPopularDishes());
        return "viewhtml/main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
