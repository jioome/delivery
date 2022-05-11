package com.jioo.delivery.repository;

import com.jioo.delivery.domain.Order;
import com.jioo.delivery.oauth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByRestaurant(Long restaurantId);
}
