package com.ordersystem.myshop.repository;

import com.ordersystem.myshop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

  //  Optional<Member> findById(Long id);
    List<Member> findByUsername(String username);
}
