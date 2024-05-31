package com.example.cashbook.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String memberid;
    private String memberpw;
    private String membername;
    private boolean enabled;
    private String rolename;

    public LoginUserDetails(MemberDTO memberDTO) {
        super();
        this.memberid = memberDTO.getMemberid();
        this.memberpw = memberDTO.getMemberpw();
        this.membername = memberDTO.getMembername();
        this.enabled = memberDTO.isEnabled();
        this.rolename = memberDTO.getRolename();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            private static final long serialVersionUID = 1L;
            
            @Override
            public String getAuthority() {
               return rolename;
            }
            
        });

        return null;
    }

    @Override
    public String getPassword() {
        return this.memberpw;
    }

    @Override
    public String getUsername() {
        return this.memberid; // id 반환
    }

    public String getUserName() {
        return this.membername; // 이름 반환
    }
    
}
