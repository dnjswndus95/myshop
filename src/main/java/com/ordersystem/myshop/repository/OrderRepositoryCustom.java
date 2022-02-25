package com.ordersystem.myshop.repository;


import com.ordersystem.myshop.entity.Order;
import com.ordersystem.myshop.entity.form.OrderSearch;

import java.util.List;

public interface OrderRepositoryCustom {

    public List<Order> findAll(OrderSearch orderSearch);
}
