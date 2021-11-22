package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Integer> {
//admin
    void deleteById(Integer id);
    @Override
    List<Dish> findAll();

    @Override
    <S extends Dish> S save(S entity);

    @Query(value = "SELECT dish.id , dish_ingredient.weight AS weight , SUM(ingredient.calories) AS calories, dish.name,src,type,price FROM dish\n" +
            " JOIN dish_ingredient ON dish.id = dish_id " +
            " JOIN ingredient ON ingredient_id = ingredient.id " +
            " WHERE dish.id = :dish.id " , nativeQuery = true)
    Dish getById(@Param("dish.id")Integer id);

    void deleteDishById(Integer id);


    List<Dish> getDishByType(String type);


}
