package com.jioo.delivery.controller;

import com.jioo.delivery.domain.Menu;
import com.jioo.delivery.domain.Order;
import com.jioo.delivery.oauth.User;
import com.jioo.delivery.service.MenuService;
import com.jioo.delivery.service.OrderService;
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

    // 내 가게 주문목록 조회
    @GetMapping("/orderlist/{id}")
    public Order readOrderList(@PathVariable Long id) {
        // 반환용 객체 사용
        return orderService.findByRestaurant(id).orElseThrow(NullPointerException::new);
    }

}

