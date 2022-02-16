package com.ordersystem.myshop.service;

import com.ordersystem.myshop.entity.Member;
import com.ordersystem.myshop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void joinTest(){
        Member member = new Member("원주연");
        Long joinMemberId = memberService.join(member);
        
        Optional<Member> findMember = memberRepository.findById(joinMemberId);
        
        Assertions.assertThat(findMember.get().getUsername()).isEqualTo(member.getUsername());
    }
}