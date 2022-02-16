package com.ordersystem.myshop.service;

import com.ordersystem.myshop.entity.Member;
import com.ordersystem.myshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    public void delete(Member member){
        memberRepository.delete(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMember = memberRepository.findByUsername(member.getUsername());
        if(!findMember.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원");
    }
}
