package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Model.UserDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDishesRepository extends JpaRepository<UserDish,Integer> {

    @Override
    List<UserDish> findAll();

    List<UserDish> findAllByUser(User user);
}
