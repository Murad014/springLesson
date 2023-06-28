package com.sec.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom-login")
public class LoginController {

    @GetMapping
    public String customLoginForm(){
        return "custom-login";
    }


}
