package com.ordersystem.myshop.controller;


import com.ordersystem.myshop.entity.Address;
import com.ordersystem.myshop.entity.Member;
import com.ordersystem.myshop.entity.DTO.MemberDto;
import com.ordersystem.myshop.entity.form.MemberForm;
import com.ordersystem.myshop.repository.MemberRepository;
import com.ordersystem.myshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    /**
     * RequiredArgsConstructor + private final 선언 = 생성자 주입
     */

    @GetMapping("/members")
    public String getMembers(Model model){
        List<Member> members = memberService.findAll();

        List<MemberDto> collect = members.stream()
                        .map(m -> new MemberDto(m.getId(), m.getUsername(), m.getAddress()))
                                .collect(Collectors.toList());

        model.addAttribute("members", collect);

        return "members/memberList";
    }

    @GetMapping("/members/new")
    public String createForm(@NotNull Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(@Valid MemberForm form, BindingResult result){
        if(result.hasErrors())
            return "members/createMemberForm";

        Member member = new Member(form.getName(), new Address(form.getCity(), form.getStreet(), form.getZipcode()));
        memberService.join(member);

        return "redirect:/";
    }


}
