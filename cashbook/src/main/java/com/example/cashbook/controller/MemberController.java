package com.example.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cashbook.dto.MemberDTO;
import com.example.cashbook.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/joinProc")
    public String joinProc(
        @ModelAttribute MemberDTO memberDTO
    ) {
        // role, enabled 세팅
        memberDTO.setRolename("ROLE_USER");
        memberDTO.setEnabled(true);

        memberService.joinProc(memberDTO);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }
}
