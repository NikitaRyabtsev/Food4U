package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Integer> {
//admin
    void deleteById(Integer id);
    @Override
    List<Dish> findAll();

    Dish getById(Integer id);

    @Query(value = "INSERT INTO dish_has_ingredient(dish_id,ingredient_id) VALUES (?,?)",nativeQuery = true)
    Dish addIngerdientInDish(Integer dishId , Integer ingredientId);

    List<Dish> getDishByType(String type);
}
