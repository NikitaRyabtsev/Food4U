package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {

    @Override
    List<Dish> findAll();

    Dish getById(Integer id);

    void deleteById(Integer id);

    List<Dish> getDishByType(String type);
}
