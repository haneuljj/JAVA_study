package com.example.cashbook.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.cashbook.dto.AnnualCashbookDTO;
import com.example.cashbook.dto.CashbookDTO;
import com.example.cashbook.entity.CashbookEntity;
import com.example.cashbook.entity.MemberEntity;
import com.example.cashbook.repository.CashbookRepository;
import com.example.cashbook.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CashbookService {
    
    private final CashbookRepository cashbookRepository;
    private final MemberRepository memberRepository;

    public List<CashbookDTO> getAllInfo(String memberid) {
        MemberEntity memberEntity =  memberRepository.findById(memberid).get();

        List<CashbookEntity> cashbookEntityList = cashbookRepository.findByMemberEntityOrderByInfonumAsc(memberEntity);

        List<CashbookDTO> cashbookDTOList = new ArrayList<>();
        cashbookEntityList.forEach((entity) -> cashbookDTOList.add(CashbookDTO.toDTO(entity, memberid)));

        return cashbookDTOList;
    }

    public CashbookDTO insertCashbook(CashbookDTO cashbookDTO) {
        MemberEntity memberEntity = memberRepository.findById(cashbookDTO.getMemberid()).get();
        CashbookEntity cashbookEntity = CashbookEntity.toEntity(cashbookDTO, memberEntity);

        CashbookEntity savedCashbookEntity = cashbookRepository.save(cashbookEntity);
        
        return CashbookDTO.toDTO(savedCashbookEntity, cashbookDTO.getMemberid());
    }

    public boolean deleteCashbook(Long infonum) {
        cashbookRepository.deleteById(infonum);

        boolean result = cashbookRepository.existsById(infonum);

        return !result;
    }

    public List<AnnualCashbookDTO> getAnnualCashbook(List<CashbookDTO> allinfo) {
        // 연도별로 수입과 지출을 저장할 맵 생성
        Map<Integer, AnnualCashbookDTO> annualMap = new HashMap<>();
    
        // allinfo의 각 항목을 처리하여 연도별로 수입과 지출을 합산
        for (CashbookDTO info : allinfo) {
            info.setYear(info.getInputdate().getYear());
            int year = info.getYear();
    
            // 연도별로 맵에서 해당 연도의 객체를 가져오거나, 없으면 새로 생성하여 맵에 추가
            // map.computeIfAbsent : 
                // Key가 존재할 경우: 아무런 작업을 하지 않고 기존에 존재하는 Key의 Value를 리턴
                // Key가 존재하지 않는 경우: 람다식을 적용한 값을 해당 key에 저장한 후 newValue를 반환
            AnnualCashbookDTO annualInfo = annualMap.computeIfAbsent(year, k -> new AnnualCashbookDTO(year, 0, 0));
    
            // 수입인 경우 수입에 합산
            if (info.getType().equals("수입")) {
                annualInfo.setIncome(annualInfo.getIncome() + info.getAmount());
            }
            // 지출인 경우 지출에 합산
            else if (info.getType().equals("지출")) {
                annualInfo.setExpense(annualInfo.getExpense() + info.getAmount());
            }
    
            // 맵에 연도별 객체를 업데이트
            annualMap.put(year, annualInfo);
        }
    
        // 맵의 값들을 리스트로 변환하여 반환
        return new ArrayList<>(annualMap.values());
    }


}
