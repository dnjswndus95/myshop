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

    private String name;
    private int price;
    private int stockQuantity;

    public void addStockQuantity(int add){
        this.stockQuantity += add;
    }

    public void subtractStockQuantity(int sub){
        if(this.stockQuantity >= sub)
            this.stockQuantity -= sub;
        else
            throw new NotEnoughStockException("재고가 부족합니다.");

    }

    protected Item() {

    }
    public Item(Long id, String itemName, int price, int stockQuantity) {
        this.id = id;
        this.name = itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Item(String itemName, int price, int stockQuantity) {
        this.name = itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void updateItem(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
