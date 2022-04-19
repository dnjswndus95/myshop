package com.ordersystem.myshop.entity.DTO;

import com.ordersystem.myshop.entity.Address;
import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String username;

    private Address address;

    public MemberDto(Long id, String name, Address address){

        this.id = id;
        this.username = name;
        this.address = new Address(address.getCity(), address.getStreet(), address.getZipcode());
    }
}
