-- 영화 정보 테이블
DROP TABLE movie;
DROP SEQUENCE movie_seq;

CREATE TABLE movie
(
    movie_num NUMBER PRIMARY KEY                -- 영화 번호
    , movie_title VARCHAR2(300) NOT NULL        -- 영화 제목
    , movie_director VARCHAR2(200) NOT NULL     -- 영화 감독명
    , movie_genre VARCHAR2(100) NOT NULL        -- 영화 장르
    , release_date DATE NOT NULL                 -- 개봉일
);

CREATE SEQUENCE movie_seq;

ALTER TABLE movie ADD photo_url VARCHAR2(1000);
-- 관람평 테이블

DROP TABLE review;
DROP SEQUENCE review_seq;

CREATE TABLE review
(
    review_num NUMBER PRIMARY KEY               -- 관람평 번호
    , movie_num NUMBER REFERENCES movie(movie_num) ON DELETE CASCADE    -- 영화번호(FK)
    , userid VARCHAR2(100) NOT NULL             -- 작성자아이디
    , review_content VARCHAR2(1000) NOT NULL    -- 관람평 내용
    , create_date DATE DEFAULT sysdate          -- 작성일
);

CREATE SEQUENCE review_seq;