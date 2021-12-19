package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.domain.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;


//비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도
@Service
public class RestaurantService {

    private final List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant create(RestaurantRequest restaurantParameter) {
        final Restaurant restaurant = new Restaurant(restaurants.size()+1L, restaurantParameter.getName(), restaurantParameter.getAddress());
        restaurants.add(restaurant);
        return restaurant;
    }


    public List<Restaurant> getAllRestaurants(){
        return restaurants;
    }

    public Restaurant read(Long id) throws Exception {
        // 자바 언어 버전 별 변천사
        // stream
        final Restaurant foundRestaurant = restaurants
                .stream()
                .filter(restaurant -> Objects.equals(restaurant.getId(), id))
                .findFirst()
                // 못찾을 경우
                .orElseThrow(() -> new Exception("없어!"));

        return foundRestaurant;
    }



    public void update(Long id, RestaurantRequest restaurantParameter) throws Exception {

        final Restaurant updateRestaurant = restaurants
                .stream()
                .filter(restaurant -> Objects.equals(restaurant.getId(), id))
                .findFirst()
                // 못찾을 경우
                .orElseThrow(() -> new Exception("없어!"));
//              .setName(restaurantParameter.getName());


    }

    public void delete(Long id) {
        restaurants.removeIf(restaurant -> Objects.equals(restaurant.getId(), id));
    }
}
