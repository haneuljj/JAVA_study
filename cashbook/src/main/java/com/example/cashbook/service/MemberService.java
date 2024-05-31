package com.example.cashbook.service;

import java.lang.reflect.Member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cashbook.dto.MemberDTO;
import com.example.cashbook.entity.MemberEntity;
import com.example.cashbook.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean joinProc(MemberDTO memberDTO) {
        boolean isExistMember = memberRepository.existsById(memberDTO.getMemberid());

        if(isExistMember) return false;

        memberDTO.setMemberpw(bCryptPasswordEncoder.encode(memberDTO.getMemberpw()));

        MemberEntity member = MemberEntity.builder()
                                .memberid(memberDTO.getMemberid())
                                .membername(memberDTO.getMembername())
                                .memberpw(memberDTO.getMemberpw())
                                .enabled(memberDTO.isEnabled())
                                .rolename(memberDTO.getRolename())
                                .build();

        memberRepository.save(member);
        
        return true;
    }
    
}
