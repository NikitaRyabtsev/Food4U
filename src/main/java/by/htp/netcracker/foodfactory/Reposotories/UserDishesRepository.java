package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Model.UserDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDishesRepository extends JpaRepository<UserDish,Integer> {

    @Override
    List<UserDish> findAll();

    List<UserDish> findAllByUser(User user);

    @Modifying
    @Query(value = "DELETE user_dish FROM user_dish WHERE dish_id= :dish_id" , nativeQuery = true)
    void deleteByDishId(@Param("dish_id") Integer id);
}
