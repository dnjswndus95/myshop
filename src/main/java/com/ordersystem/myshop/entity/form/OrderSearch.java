package com.ordersystem.myshop.entity.form;


import com.ordersystem.myshop.entity.OrderStatus;
import lombok.Getter;

@Getter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;


}
