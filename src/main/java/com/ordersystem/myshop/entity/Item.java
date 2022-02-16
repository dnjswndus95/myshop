package com.ordersystem.myshop.entity;

import com.ordersystem.myshop.exception.NotEnoughStockException;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String itemName;
    private Integer price;
    private int stockQuantity;

    public void addStockQuantity(int add){
        this.stockQuantity += add;
    }

    public void subtractStockQuantity(int sub){
        if(this.stockQuantity >= sub)
            this.stockQuantity -= sub;
        else
            throw new NotEnoughStockException("수량 부족");

    }

    protected Item() {

    }

    public Item(String itemName, Integer price, int stockQuantity) {
        this.itemName = itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
