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
        dish.setName(dishWrapperDto.getDishDto().getName());
        dish.setPrice(dishWrapperDto.getDishDto().getPrice());
        dish.setSrc(dishWrapperDto.getDishDto().getSrc());
        dish.setType(dishWrapperDto.getDishDto().getType());
        if (dishWrapperDto.getDishIngredientDto() != null || dishWrapperDto.getDishIngredientDto().isEmpty()) {
            for (int i = 0; i < dishWrapperDto.getDishIngredientDto().size(); i++) {
                Ingredient ingredient = ingredientRepository.getById(dishWrapperDto.getDishIngredientDto().get(i).getIngredient());
                DishIngredient dishIngredient = new DishIngredient();
                dishIngredient.setIngredient(ingredient);
                dishIngredient.setWeight(dishWrapperDto.getDishIngredientDto().get(i).getWeight());
                dishIngredient.setDish(dish);
                dishIngredientsRepository.save(dishIngredient);
            }

        }
        dishRepository.save(dish);
    }
}
