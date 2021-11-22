package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.OrdersDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDishesRepository extends JpaRepository<OrdersDish,Integer> {

    @Override
    List<OrdersDish> findAll();
}
