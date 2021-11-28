package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    @Override
    List<Orders> findAll();

    @Modifying
    @Query(value = "DELETE order_has_dish FROM order_has_dish WHERE dish_id = :dish_id" , nativeQuery = true)
    void deleteDishFromOrderById(@Param("dish_id") Integer id);

    List<Orders> findOrdersByUserOrderById(User user);

    Orders findByUser(User user);

    List<Orders> findAllByUser(User user);

    @Modifying
    @Query(value = "UPDATE orders SET status = :status WHERE id = :id" , nativeQuery = true)
    Orders updateOrderStatusById(@Param("status") String status ,@Param("id") Integer id);


}
