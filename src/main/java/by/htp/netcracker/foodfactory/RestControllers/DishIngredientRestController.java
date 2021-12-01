package by.htp.netcracker.foodfactory.RestControllers;


import by.htp.netcracker.foodfactory.Dto.DishIngredientDto;
import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Reposotories.DishIngredientsRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/dishIngredient")
public class DishIngredientRestController {

    private final DishIngredientsRepository dishIngredientsRepository;
    private final IngredientRepository ingredientRepository;

    public DishIngredientRestController(DishIngredientsRepository dishIngredientsRepository ,
                                        IngredientRepository ingredientRepository) {
        this.dishIngredientsRepository = dishIngredientsRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/addDish",method = RequestMethod.POST,produces ="application/json")
    public void addDishIngredient(@RequestBody DishIngredientDto dishIngredientDto){
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setIngredient(ingredientRepository.getById(dishIngredientDto.getIngredient()));
        dishIngredient.setWeight(dishIngredientDto.getWeight());
        dishIngredientsRepository.save(dishIngredient);
    }

}