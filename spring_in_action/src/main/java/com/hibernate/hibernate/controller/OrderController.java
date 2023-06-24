package com.hibernate.hibernate.controller;

import com.hibernate.hibernate.entity.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
@Controller
public class OrderController {

    @GetMapping("/current")
    public String currentOrder(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus){

        if(errors.hasErrors())
            return "orderForm";


        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }







}
