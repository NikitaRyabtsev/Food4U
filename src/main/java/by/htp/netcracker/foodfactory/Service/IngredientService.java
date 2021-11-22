package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.Ingredient;
import by.htp.netcracker.foodfactory.Reposotories.IngredientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findIngredientsAndSort(){
        return ingredientRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }
}
