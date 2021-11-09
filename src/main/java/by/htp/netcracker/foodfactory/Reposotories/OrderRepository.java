package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAll();

    Order getOrderByUser(Order order);

    Order save(Order order);

    Order getById(Integer id);

    void deleteById(Integer id);
}
