package com.ordersystem.myshop.entity.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "필수 입력사항입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;


}
