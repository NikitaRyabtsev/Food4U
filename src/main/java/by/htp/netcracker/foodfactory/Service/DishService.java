package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private final  DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }
    public List<Dish> findDishesSortByType(){return dishRepository.findAll(Sort.by(Sort.Direction.DESC,"type"));}


    public List<DishIngredient> createDish(){
        List<DishIngredient> dishIngredientList = new ArrayList<>();
        dishIngredientList.add(new DishIngredient());
        return dishIngredientList;
    }



}
