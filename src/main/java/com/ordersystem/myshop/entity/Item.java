package com.ordersystem.myshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    private String itemName;
    private Integer price;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


}
