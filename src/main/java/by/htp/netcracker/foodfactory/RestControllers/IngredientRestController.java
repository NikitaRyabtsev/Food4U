package by.htp.netcracker.foodfactory.RestControllers;


import by.htp.netcracker.foodfactory.Model.Ingredient;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/ingredients")
public class IngredientRestController {

    private IngredientRepository ingredientRepository;

    public IngredientRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @GetMapping(produces = "application/json")
    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }
}