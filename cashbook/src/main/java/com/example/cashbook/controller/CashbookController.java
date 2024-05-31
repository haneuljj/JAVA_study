package com.example.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.example.cashbook.service.CashbookService;
import com.example.cashbook.dto.AnnualCashbookDTO;
import com.example.cashbook.dto.CashbookDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cashbook")
@RequiredArgsConstructor
@Slf4j
public class CashbookController {

    private final CashbookService cashbookService;
    
    @GetMapping("/myCashbook")
    public String myCashbook(
        @RequestParam("memberid") String memberid,
        Model model
    ) {
        List<CashbookDTO> allinfo = cashbookService.getAllInfo(memberid);

        model.addAttribute("allCashbook", allinfo);
        model.addAttribute("memberid", memberid);

        return "cashbook/myCashbook";
    }

    @PostMapping("/insertCashbook")
    @ResponseBody
    public CashbookDTO inserCashbook(
        @ModelAttribute CashbookDTO cashbookDTO
    ) {
        log.info("====={}", cashbookDTO);

        CashbookDTO savedCashbookDTO = cashbookService.insertCashbook(cashbookDTO);

        return savedCashbookDTO;
    }

    @GetMapping("/deleteCashbook")
    @ResponseBody
    public boolean deleteCashbook(
        @RequestParam(name = "infonum") Long infonum
    ) {
        log.info("====삭제하기 도착, {}", infonum);

        boolean result = cashbookService.deleteCashbook(infonum);

        return result;
    }

    @GetMapping("/annualStat")
    public String annualStat(
        @RequestParam("memberid") String memberid,
        Model model
    ) {
        // 멤버아이디에 해당하는 가계부 내역 모두 가져오기
        List<CashbookDTO> allinfo = cashbookService.getAllInfo(memberid);
        // 그 내역을 전달하여 연도별 통계로 바꿔주기
        List<AnnualCashbookDTO> annaulList = cashbookService.getAnnualCashbook(allinfo);
        log.info("======annualList : {}", annaulList);

        model.addAttribute("annaulList", annaulList);

        return "cashbook/annualStat";
    }
}
