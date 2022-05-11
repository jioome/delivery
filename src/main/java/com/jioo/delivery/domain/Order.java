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

//    @Column(name = "status")
//    @Convert(converter = OrderType.Converter.class)
//    private OrderType status;
}
