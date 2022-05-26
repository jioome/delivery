package com.jioo.delivery.domain;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "orderer_id")
    private Long ordererId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getOrdererId() {
        return ordererId;
    }

    public void setOrdererId(Long ordererId) {
        this.ordererId = ordererId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
//    @Column(name = "status")
//    @Convert(converter = OrderType.Converter.class)
//    private OrderType status;
}
