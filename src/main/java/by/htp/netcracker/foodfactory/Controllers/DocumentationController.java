package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentation")
public class DocumentationController {

    private IngredientRepository ingredientRepository;

    public DocumentationController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/client")
    public String showClientDocumentation(){
        return "documentation/client";
    }

    @GetMapping("/developer")
    public String showDeveloperDocumentation(){
        return "documentation/developer";
    }


    @GetMapping("/test")
    public String find(Model model){
        model.addAttribute("ingredients" , ingredientRepository.findAll());
        return "documentation/test";
    }

}
