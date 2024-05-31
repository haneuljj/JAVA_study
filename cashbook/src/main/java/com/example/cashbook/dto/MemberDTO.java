package com.example.cashbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MemberDTO {
    private String memberid;
    private String memberpw;
    private String membername;
    private boolean enabled;
    private String rolename;

    /**
     * memberid VARCHAR2(20) PRIMARY KEY
    , memberpw VARCHAR2(100) NOT NULL
    , membername VARCHAR2(20) NOT NULL
    , enabled NUMBER(1) DEFAULT '1' CHECK(enabled IN ('1', '0'))
    , rolename VARCHAR2(20) DEFAULT 'ROLE_USER'
     */
}
