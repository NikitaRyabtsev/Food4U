package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Dto.OrderDishDto;
import by.htp.netcracker.foodfactory.Helper.MathRandom;
import by.htp.netcracker.foodfactory.Helper.OrderStatus;
import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Model.OrderDish;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrdersRepository;
import by.htp.netcracker.foodfactory.Reposotories.OrderDishesRepository;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import by.htp.netcracker.foodfactory.RestControllers.OrderRestController;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;
    private final OrderDishesRepository orderDishesRepository;
    private final DishRepository dishRepository;
    private  BigDecimal counter = null;

    public OrderService(UserRepository userRepository, OrdersRepository ordersRepository,
                        OrderDishesRepository userDishesRepository, DishRepository dishRepository) {
        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
        this.orderDishesRepository = userDishesRepository;
        this.dishRepository = dishRepository;
    }

    public List<Orders> findOrdersByUser(String username) {
        User user = userRepository.getUserByUsername(username);
        List<Orders> orders = ordersRepository.findAllByUser(user, Sort.by(Sort.Direction.DESC, "dateTimeOfBooking"));
        return orders;
    }

    public void saveOrderWithOrderDish(OrderDishDto orderDishDto, String username) {
        User user = userRepository.getUserByUsername(username);
        Orders checkOrders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        if (checkOrders != null) {
            counter = counter.add(orderDishDto.getPrice().multiply(BigDecimal.valueOf(orderDishDto.getCountOfDishes())));
            checkOrders.setPrice(counter);
            Dish dish =  dishRepository.getById(orderDishDto.getDish());
            OrderDish orderDish = orderDishesRepository.findByOrderAndDish(checkOrders, dish);
            initAndCheckOrderDish(orderDish,orderDishDto,user);
        } else {
            Orders order = initOrder(user,orderDishDto);
            OrderDish orderDish = new OrderDish();
            orderDish.setDish(dishRepository.getById(orderDishDto.getDish()));
            orderDish.setCountOfDishes(orderDishDto.getCountOfDishes());
            orderDish.setOrder(order);
            orderDishesRepository.save(orderDish);
            ordersRepository.save(order);
        }
    }

    public Orders findActiveOrder(String username) {
        User user = userRepository.getUserByUsername(username);
        Orders orders = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        return orders;
    }


    public void saveActiveOrder(Orders order, String username) {
        User user = userRepository.getUserByUsername(username);
        order = ordersRepository.findOrdersByUserAndStatus(user, OrderStatus.CONSIDERED.toString());
        order.setDateTimeOfBooking(LocalDateTime.now());
        order.setStatus(OrderStatus.FORMALIZED.toString());
        ordersRepository.save(order);
    }

    public void deleteDishFromOrder(Integer id, String username) {
        Orders checkOrder = findActiveOrder(username);
        OrderDish orderDish = orderDishesRepository.findOrderDishByDishIdAndOrderId(id,checkOrder.getId());
        counter = checkOrder.getPrice();
        counter = counter.subtract(orderDish.getDish().getPrice().multiply(BigDecimal.valueOf(orderDish.getCountOfDishes())));
        checkOrder.setPrice(counter);
        orderDishesRepository.deleteByDishId(id);
        ordersRepository.save(checkOrder);
        deleteEmptyOrder(checkOrder);
    }

    public void confirmOrderByAdmin(Integer id) {
        Orders orders = ordersRepository.findOrdersById(id);
        orders.setStatus(OrderStatus.DONE.toString());
        ordersRepository.save(orders);
    }

    public List<Orders> showOrdersOrderByDateAndTime() {
        return ordersRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTimeOfBooking"));
    }

    private void deleteEmptyOrder(Orders checkOrder) {
        List<OrderDish> orderDishes = orderDishesRepository.findAllByOrder(checkOrder);
        if(orderDishes == null || orderDishes.isEmpty()) {
            ordersRepository.deleteOrdersById(checkOrder.getId());
        }
    }

    private Orders initOrder(User user, OrderDishDto orderDishDto){
        Orders orders = new Orders();
        orders.setNumberOfBooking(MathRandom.generateNumberOfBooking());
        orders.setUser(user);
        counter = orderDishDto.getPrice().multiply(BigDecimal.valueOf(orderDishDto.getCountOfDishes()));
        orders.setPrice(counter);
        orders.setStatus(OrderStatus.CONSIDERED.toString());
        return orders;
    }

    private OrderDish initAndCheckOrderDish(OrderDish orderDish ,OrderDishDto orderDishDto , User user){
        if (orderDish != null) {
            orderDish.setCountOfDishes(orderDish.getCountOfDishes() + orderDishDto.getCountOfDishes());
            orderDishesRepository.save(orderDish);
        } else {
            orderDish = new OrderDish();
            orderDish.setDish(dishRepository.getById(orderDishDto.getDish()));
            orderDish.setCountOfDishes(orderDishDto.getCountOfDishes());
            orderDish.setOrder(findActiveOrder(user.getUsername()));
            orderDishesRepository.save(orderDish);
        }
        return orderDish;
    }
}
