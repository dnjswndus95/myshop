package com.ordersystem.myshop.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Embedded
    private Address address;

    public void setOrder(Order order){
        this.order = order;
    }

    protected Delivery(){
    }

    public Delivery(Address address, DeliveryStatus status){
        this.address = address;
        this.deliveryStatus = status;
    }

}
