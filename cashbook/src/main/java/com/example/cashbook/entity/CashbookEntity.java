package com.example.cashbook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.example.cashbook.dto.CashbookDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
@Table(name = "cashbook_info")
public class CashbookEntity {

    @SequenceGenerator(
        name = "cashbook_seq"
        , sequenceName = "cashbook_seq"
        , initialValue = 1
        , allocationSize = 1
    )
    @Id
    @GeneratedValue(generator = "cashbook_seq")
    private Long infonum;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String memo;
    private int amount;

    @CreationTimestamp
    private LocalDate inputdate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberid") 
    private MemberEntity memberEntity;

    public static CashbookEntity toEntity(CashbookDTO cashbookDTO, MemberEntity memberEntity) {
        return CashbookEntity.builder()
                    .infonum(cashbookDTO.getInfonum())
                    .type(cashbookDTO.getType())
                    .memo(cashbookDTO.getMemo())
                    .amount(cashbookDTO.getAmount())
                    .inputdate(cashbookDTO.getInputdate())
                    .memberEntity(memberEntity)
                    .build();
    }
}
