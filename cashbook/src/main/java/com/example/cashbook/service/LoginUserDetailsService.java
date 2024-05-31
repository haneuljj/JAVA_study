package com.example.cashbook.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cashbook.dto.LoginUserDetails;
import com.example.cashbook.dto.MemberDTO;
import com.example.cashbook.entity.MemberEntity;
import com.example.cashbook.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService{
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity member = memberRepository.findById(username)
                    .orElseThrow(() -> {
                        throw new UsernameNotFoundException("존재하지 않는 회원입니다.");
                    });
                    
        MemberDTO memberDTO = MemberDTO.builder()
                                .memberid(member.getMemberid())
                                .membername(member.getMembername())
                                .memberpw(member.getMemberpw())
                                .enabled(member.isEnabled())
                                .rolename(member.getRolename())
                                .build();

        return new LoginUserDetails(memberDTO);
    }
    
}
