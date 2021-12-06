package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Dto.DishDto;
import by.htp.netcracker.foodfactory.Dto.DishIngredientDto;
import by.htp.netcracker.foodfactory.Dto.DishWrapperDto;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import by.htp.netcracker.foodfactory.Reposotories.DishIngredientsRepository;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
    private final DishIngredientsRepository dishIngredientsRepository;

    public DishService(DishRepository dishRepository, IngredientRepository ingredientRepository, DishIngredientsRepository dishIngredientsRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.dishIngredientsRepository = dishIngredientsRepository;
    }

    public List<Dish> findDishesSortByType() {
        return dishRepository.findAll(Sort.by(Sort.Direction.DESC, "type"));
    }


    public void createDishWithIngredients(DishWrapperDto dishWrapperDto) {
        Dish dish = new Dish();
        double caloriesCounter = 0;
        double weightCounter = 0;
        dish.setName(dishWrapperDto.getDishDto().getName());
        dish.setPrice(dishWrapperDto.getDishDto().getPrice());
        dish.setSrc(dishWrapperDto.getDishDto().getSrc());
        dish.setType(dishWrapperDto.getDishDto().getType());
        if(dish.getSrc() == null) {
            dish.setSrc("https://res.cloudinary.com/finishhim123nik/image/upload/v1638612922/dishes2/85268e4c799b9e91a6f9d209ea1cc1f3_lvwbbi.jpg");
        }
        if (dishWrapperDto.getDishIngredientDto() != null || dishWrapperDto.getDishIngredientDto().isEmpty()) {
            for (int i = 0; i < dishWrapperDto.getDishIngredientDto().size(); i++) {
                Ingredient ingredient = ingredientRepository.getById(dishWrapperDto.getDishIngredientDto().get(i).getIngredient());
                DishIngredient dishIngredient = new DishIngredient();
                dishIngredient.setIngredient(ingredient);
                dishIngredient.setWeight(dishWrapperDto.getDishIngredientDto().get(i).getWeight());
                dishIngredient.setDish(dish);
                caloriesCounter += dishIngredient.getIngredient().getCalories();
                weightCounter += dishIngredient.getWeight();
                dishIngredientsRepository.save(dishIngredient);
            }
            dish.setWeight(Math.round(weightCounter));
            dish.setCalories(Math.round((caloriesCounter * 100)/dish.getWeight()));
        }
        dishRepository.save(dish);
    }
}
