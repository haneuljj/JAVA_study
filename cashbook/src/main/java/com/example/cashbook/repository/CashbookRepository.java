package com.example.cashbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cashbook.entity.CashbookEntity;
import com.example.cashbook.entity.MemberEntity;

public interface CashbookRepository extends JpaRepository<CashbookEntity, Long>{

    List<CashbookEntity> findByMemberEntityOrderByInfonumAsc(MemberEntity memberEntity);
    
}
