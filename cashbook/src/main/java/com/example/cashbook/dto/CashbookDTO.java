package com.example.cashbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import com.example.cashbook.entity.CashbookEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CashbookDTO {
    private Long infonum;
    private String memberid;
    private String type;
    private String memo;
    private int amount;
    private LocalDate inputdate;
    // 연도별 통계 얻을 때 필요한 값
    private int year;
    
    public static CashbookDTO toDTO(CashbookEntity cashbookEntity, String memberid) {
        return CashbookDTO.builder()
                    .infonum(cashbookEntity.getInfonum())
                    .type(cashbookEntity.getType())
                    .memo(cashbookEntity.getMemo())
                    .amount(cashbookEntity.getAmount())
                    .inputdate(cashbookEntity.getInputdate())
                    .memberid(memberid)
                    .build();
    }
}
