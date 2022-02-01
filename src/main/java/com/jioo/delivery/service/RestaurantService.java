package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.domain.User;
import com.jioo.delivery.repository.RestaurantRepository;
import com.jioo.delivery.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


//비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도
@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserService userService;

    // Repository
    private final List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant create(RestaurantRequest restaurantParameter) {
        final User user = userService.read(restaurantParameter.getOwnerId());
        final Restaurant restaurant = new Restaurant(restaurantParameter.getAddress(), restaurantParameter.getName(), restaurantParameter.getCallNumber(), user);
        return restaurantRepository.save(restaurant);
    }


    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant read(Long id) throws Exception {
        // 자바 언어 버전 별 변천사
        // stream - 함수형 프로그래밍 1.  불변성
        // 3. lazy evaluation

        return restaurantRepository.findById(id).orElseThrow(NullPointerException::new);
    }


    public Restaurant update(Long id, RestaurantRequest restaurantParameter) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isEmpty()){
            throw new EntityNotFoundException(
                    "Member not present in the database"
            );
        }
        Restaurant updateRestaurant = optionalRestaurant.get();
        updateRestaurant.setName(restaurantParameter.getName());
        updateRestaurant.setAddress(restaurantParameter.getAddress());
        updateRestaurant.setCallNumber(restaurantParameter.getCallNumber());


        return restaurantRepository.save(updateRestaurant);

    }

    public void delete(Long id) {
         restaurantRepository.deleteById(id);
    }
}
