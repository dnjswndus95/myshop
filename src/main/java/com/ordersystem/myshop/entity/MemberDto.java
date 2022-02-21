package com.ordersystem.myshop.entity;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String name;

    private Address address;

    public MemberDto(Long id, String name, Address address){
        this.id = id;
        this.name = name;
        this.address = new Address(address.getCity(), address.getStreet(), address.getZipcode());
    }
}
