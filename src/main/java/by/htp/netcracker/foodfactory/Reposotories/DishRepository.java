package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Integer> {
//admin
    void deleteById(Integer id);
    @Override
    List<Dish> findAll();

    @Override
    <S extends Dish> S save(S entity);

    Dish getById(Integer id);

    void deleteDishById(Integer id);

    @Modifying
    @Query(value = "SELECT *, COUNT(dish.name) FROM dish " +
            " JOIN order_dish ON dish.id = order_dish.dish_id  " +
            " JOIN orders ON order_dish.order_id = orders.id " +
            " GROUP BY dish.name  " +
            " ORDER BY COUNT(dish.name) DESC " +
            " LIMIT 3;" , nativeQuery = true)
    List<Dish> findTheMostPopularDishes();

    List<Dish> getDishByType(String type);


}
