package com.ordersystem.myshop.repository;

import com.ordersystem.myshop.entity.Address;
import com.ordersystem.myshop.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {


    @Autowired MemberRepository memberRepository;

    @Test
    public void saveTest(){
        Member member = new Member("원주연", new Address("인천시", "송도문화로", "그린스퀘어"));
        memberRepository.save(member);

        Optional<Member> findMember = memberRepository.findById(member.getId());

        assertThat(findMember.get().getUsername()).isEqualTo(member.getUsername());
    }
}