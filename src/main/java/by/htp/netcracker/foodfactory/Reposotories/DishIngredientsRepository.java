package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishIngredientsRepository extends JpaRepository<DishIngredient,Integer> {

    @Override
    List<DishIngredient> findAll();

    @Modifying
    @Query(value = "DELETE FROM dish_ingredient WHERE dish_id = :dish_id" , nativeQuery = true)
    void deleteByDishId(@Param("dish_id")Integer id);

    @Override
    <S extends DishIngredient> S save(S entity);

    List<DishIngredient> findAllByIngredient(Ingredient ingredient);

    @Override
    <S extends DishIngredient> List<S> saveAll(Iterable<S> entities);
}
