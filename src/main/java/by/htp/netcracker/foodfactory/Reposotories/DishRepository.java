package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Integer> {
//admin
    void deleteById(Integer id);
    @Override
    List<Dish> findAll();

    Dish save(Dish dish);

    Dish getById(Integer id);

    List<Dish> getDishByType(String type);

}
