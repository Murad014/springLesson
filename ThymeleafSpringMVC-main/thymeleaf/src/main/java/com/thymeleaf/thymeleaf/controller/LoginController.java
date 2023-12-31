package com.thymeleaf.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "login/access_denied";
    }
}
