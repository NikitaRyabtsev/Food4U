package by.htp.netcracker.foodfactory.Controllers;

import by.htp.netcracker.foodfactory.Model.Ingredient;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Service.IngredientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ingredients")
public class IngredientsController {

    private IngredientService ingredientService;
    private IngredientRepository ingredientRepository;

    public IngredientsController(IngredientRepository ingredientRepository , IngredientService ingredientService) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public String showAllIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.findIngredientsAndSort());
        return "ingredients/ingredients";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/new")
    public String newIngredient(Model model){
        model.addAttribute("ingredient",new Ingredient());
        return "ingredients/newIngredient";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/new")
    public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping("/{id}")
    public String getIngredientById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ingredient", ingredientRepository.getById(id));
        return "ingredients/ingredientById";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{id}/edit")
    public String editIngredient(Model model,@PathVariable("id")Integer id){
        model.addAttribute("ingredient", ingredientRepository.getById(id));
        return "ingredients/ingredientEdit";

    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{id}/edit")
    public String updateIngredient(@ModelAttribute("ingredient") Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{id}/delete")
    public String deleteIngredient(@PathVariable("id")Integer id){
        ingredientRepository.deleteById(id);
        return "redirect:/ingredients";
    }



}
