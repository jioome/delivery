package com.jioo.delivery.service;

import com.jioo.delivery.domain.Menu;
import com.jioo.delivery.domain.Order;
import com.jioo.delivery.oauth.User;
import com.jioo.delivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order read(Long id) {
        return orderRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Optional<Order> findByRestaurant(Long restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId) ;
    }

}
