package by.htp.netcracker.foodfactory.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String toMainPage() {
        return "viewhtml/main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
