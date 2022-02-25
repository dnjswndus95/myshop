package com.ordersystem.myshop.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
@Getter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private void setItem(Item item){ this.item = item;}


    protected OrderItem(){
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.orderPrice = orderPrice;
        orderItem.count = count;

        item.subtractStockQuantity(count);
        return orderItem;
    }

    public void cancel(){
        getItem().addStockQuantity(count);
    }
}
