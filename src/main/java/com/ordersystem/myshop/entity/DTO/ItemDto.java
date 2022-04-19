package com.ordersystem.myshop.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public ItemDto(Long id, String name, int price, int stockQuantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;

    }
}
