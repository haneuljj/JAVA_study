package com.example.cashbook.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cashbook.dto.LoginUserDetails;

@Controller
public class MainController {
    
    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/main")
    public String main(
        @AuthenticationPrincipal LoginUserDetails loginUser
            , Model model
    ) {

        if (loginUser != null) {
            model.addAttribute("membername", loginUser.getUserName());
            model.addAttribute("memberid", loginUser.getUsername());
        }

        return "main";
    }
}
