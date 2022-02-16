package com.ordersystem.myshop.controller;


import com.ordersystem.myshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    /**
     * RequiredArgsConstructor + private final 선언 = 생성자 주입
     */

}
