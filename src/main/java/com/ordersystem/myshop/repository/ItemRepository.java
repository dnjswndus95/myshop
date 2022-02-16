package com.ordersystem.myshop.repository;

import com.ordersystem.myshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
