/* 회원 정보 테이블 */
CREATE TABLE cashbook_member
(
    memberid VARCHAR2(20) PRIMARY KEY
    , memberpw VARCHAR2(100) NOT NULL
    , membername VARCHAR2(20) NOT NULL
    , enabled NUMBER(1) DEFAULT '1' CHECK(enabled IN ('1', '0'))
    , rolename VARCHAR2(20) DEFAULT 'ROLE_USER'
);

/* 가계부 내역 테이블 */
CREATE TABLE cashbook_info
(
    infonum NUMBER PRIMARY KEY
    , memberid VARCHAR2(20) NOT NULL
    , type VARCHAR2(20) NOT NULL
    , memo VARCHAR2(100) NOT NULL
    , amount NUMBER DEFAULT 0
    , inputdate DATE DEFAULT SYSDATE
    , CONSTRAINT fk_cashbook_memberid FOREIGN KEY (memberid) REFERENCES cashbook_member(memberid)
);
CREATE SEQUENCE cashbook_seq;

