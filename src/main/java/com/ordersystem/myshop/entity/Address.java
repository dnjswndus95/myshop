package com.ordersystem.myshop.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable             // 밸류 클래스 주소
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    //JPA 스펙상 엔티티나 임베디드 타입은 프로텍트로 기본생성자 삽입
    protected Address() {

    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
