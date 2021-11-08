package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
//admin
    @Override
    List<User> findAll();

    @Override
    void deleteById(Integer id);

    @Override
    User getById(Integer id);
//user
    User save(User user);


}
