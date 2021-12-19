package com.jioo.delivery.controller;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.controller.response.RestaurantResponse;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

//    1.쿼리 파라미터로 전달받기
//    2. Request Body로 전달받기
//    3. Path Variable 로 전달받기

    @PostMapping("/restaurant")
    public RestaurantResponse createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        final Restaurant restaurant = restaurantService.create(restaurantRequest);
        return new RestaurantResponse(restaurant);
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantResponse readRestaurant(@PathVariable Long id) throws Exception {
        final Restaurant restaurant = restaurantService.read(id);

        return new RestaurantResponse(restaurant);
    }

    @GetMapping("/restaurant")
    public List<Restaurant>  getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PutMapping("/restaurant/{id}")
    public void updateRestaurant(@PathVariable Long id,@PathVariable RestaurantRequest restaurantRequest) throws Exception {

//        return restaurantService.update(id,restaurantRequest);
            return ;
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable Long id){
        restaurantService.delete(id);

    }
}
