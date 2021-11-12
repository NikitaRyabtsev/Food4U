package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;
import javax.transaction.Transactional;

@Transactional
@Service
public class OrderService {

    @PersistenceContext
    private EntityManager entityManager;
    private OrdersRepository ordersRepository;
    private DishRepository dishRepository;

    public OrderService(OrdersRepository ordersRepository , DishRepository dishRepository){
        this.ordersRepository = ordersRepository;
        this.dishRepository = dishRepository;
    }

    @PreRemove
    public void deleteDishFromOrder(Dish dish){
       entityManager.remove(dish);
       for(Orders orders : dish.getOrders()){
           orders.getDishes().remove(dish);
       }
       entityManager.flush();
    }
}
