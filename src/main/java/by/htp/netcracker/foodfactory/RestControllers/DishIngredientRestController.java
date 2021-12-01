package by.htp.netcracker.foodfactory.RestControllers;


import by.htp.netcracker.foodfactory.Dto.DishWrapperDto;
import by.htp.netcracker.foodfactory.Reposotories.DishIngredientsRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import by.htp.netcracker.foodfactory.Service.DishService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/dishIngredient")
public class DishIngredientRestController {

    private final DishIngredientsRepository dishIngredientsRepository;
    private final IngredientRepository ingredientRepository;
    private final DishService dishService;

    public DishIngredientRestController(DishIngredientsRepository dishIngredientsRepository ,
                                        IngredientRepository ingredientRepository , DishService dishService) {
        this.dishIngredientsRepository = dishIngredientsRepository;
        this.ingredientRepository = ingredientRepository;
        this.dishService = dishService;
    }

    @ResponseBody
    @RequestMapping(value = "/addDish",method = RequestMethod.POST,produces ="application/json")
    public void addDishIngredient(@RequestBody DishWrapperDto dishWrapper){
        dishService.createDishWithIngredients(dishWrapper);
    }

}