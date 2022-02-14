package com.ordersystem.myshop.repository;

import com.ordersystem.myshop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
