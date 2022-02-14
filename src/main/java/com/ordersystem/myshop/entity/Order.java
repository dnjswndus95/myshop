package com.ordersystem.myshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
