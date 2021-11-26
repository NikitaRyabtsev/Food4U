package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.DishIngredient;
import by.htp.netcracker.foodfactory.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishIngredientsRepository extends JpaRepository<DishIngredient,Integer> {

    @Override
    List<DishIngredient> findAll();

    @Override
    <S extends DishIngredient> S save(S entity);

    List<DishIngredient> findAllByIngredient(Ingredient ingredient);


    @Override
    <S extends DishIngredient> List<S> saveAll(Iterable<S> entities);
}
