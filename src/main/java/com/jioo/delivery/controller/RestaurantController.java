package com.jioo.delivery.controller;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.controller.response.RestaurantResponse;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.oauth.User;
import com.jioo.delivery.service.RestaurantService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jioo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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


    @GetMapping("/restaurant/{id}")
    public RestaurantResponse readRestaurant(@PathVariable Long id) throws Exception {
        final Restaurant restaurant = restaurantService.read(id);
        return new RestaurantResponse(restaurant);
    }

    @GetMapping("/restaurant")
    public List<RestaurantResponse> getAllRestaurants() {
       return restaurantService.getAllRestaurants().stream()
               .map(RestaurantResponse::fromEntity).collect(Collectors.toList());

    }
//    public List<Restaurant> getAllRestaurants() {
//        return restaurantService.getAllRestaurants();
//    }

    @PutMapping("/restaurant/{id}")
    public RestaurantResponse updateRestaurant(@PathVariable Long id, @RequestBody RestaurantRequest restaurantRequest) throws Exception {

        final Restaurant restaurant = restaurantService.update(id, restaurantRequest);
        return new RestaurantResponse(restaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.delete(id);

    }
}
