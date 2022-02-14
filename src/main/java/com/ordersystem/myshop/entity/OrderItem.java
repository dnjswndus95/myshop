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

    private Integer orderPrice;
    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    protected OrderItem(){
    }

    public void setOrder(Order order){
        this.order = order;
    }


}
