package com.jioo.delivery.controller;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.controller.response.RestaurantResponse;
import com.jioo.delivery.domain.Menu;
import com.jioo.delivery.domain.Order;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.oauth.User;
import com.jioo.delivery.service.MenuService;
import com.jioo.delivery.service.OrderService;
import com.jioo.delivery.service.RestaurantService;
import com.jioo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController // RESTFul한 웹 서비스를 구축하기 위해 사용하는 것
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;


    // 내 가게 주문목록 조회
    @GetMapping("/orderlist/{id}")
    public Order readOrderList(@PathVariable Long id) {
        // 반환용 객체 사용
        return orderService.findByRestaurant(id).orElseThrow(NullPointerException::new);
    }

    // 내 가게 등록
    @PostMapping("/restaurant")
    public RestaurantResponse createRestaurant(@RequestBody RestaurantRequest restaurantRequest,@AuthenticationPrincipal UserDetails userDetails) {
        long ownerId = userService.findByEmail(userDetails.getUsername()).orElseThrow(NullPointerException::new).getId();
        final Restaurant restaurant = restaurantService.create(restaurantRequest, ownerId);
        return new RestaurantResponse(restaurant);
    }

}

