package com.ordersystem.myshop.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    protected Member(){

    }

    public Member(String username, Address address){
        this.username = username;
        this.address = new Address(address.getCity(), address.getStreet(), address.getZipcode());
    }

    public Member(String username) {
        this.username = username;
    }
}
