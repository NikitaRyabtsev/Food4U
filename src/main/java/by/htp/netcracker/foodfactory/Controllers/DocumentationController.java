package by.htp.netcracker.foodfactory.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentation")
public class DocumentationController {

    @GetMapping
    public String showDocumentation(){
        return "documentation/index";
    }

}
