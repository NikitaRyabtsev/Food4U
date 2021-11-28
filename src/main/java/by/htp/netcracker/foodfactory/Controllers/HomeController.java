package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/admin")
    public String toAdminPage() {
        return "viewhtml/admin";
    }

    @GetMapping("/main")
    public String toMainPage(){
        return "viewhtml/main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
