package by.htp.netcracker.foodfactory.RestControllers;

import by.htp.netcracker.foodfactory.Model.Dish;
import by.htp.netcracker.foodfactory.Model.Orders;
import by.htp.netcracker.foodfactory.Reposotories.DishRepository;
import by.htp.netcracker.foodfactory.Service.OrderService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/foodCracker")
public class FoodCrackerController {

    String urlForHeader = "http://localhost:8080/index.jsp";
    String url = "http://localhost:8080/ws/rest/mealForFood4U/newMeal";
    private final DishRepository dishRepository;
    private final OrderService orderService;

    public FoodCrackerController(DishRepository dishRepository, OrderService orderService) {
        this.dishRepository = dishRepository;
        this.orderService = orderService;
    }

    @RequestMapping(value="/dishes" , method = RequestMethod.GET,produces = "application/json")
    public List<Dish> dishes(){
        return dishRepository.findAll();
    }

    @RequestMapping(value = "/post/order", method = RequestMethod.POST,produces = "application/json")
    public Orders OrderPostJson(Principal principal ) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.FROM,principal.getName());
        RestTemplate restTemplate = new RestTemplate();

        Orders orders = orderService.findActiveOrder(principal.getName());

        HttpEntity<Orders> entity = new HttpEntity<>(orders,headers);

        restTemplate.postForObject(url,entity,Orders.class);
        return orders;
    }

    @RequestMapping(value =  "/post/header" , method = RequestMethod.GET)
    public void headerPostJson(Principal principal , HttpServletResponse respons) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(HttpHeaders.AUTHORIZATION,principal.getName());
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> entity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class
        );
        if (entity.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(entity.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(entity.getStatusCode());
        }
        respons.sendRedirect(url);
    }
}
