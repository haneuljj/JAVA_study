package com.example.cashbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cashbook.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String>{
    
}
