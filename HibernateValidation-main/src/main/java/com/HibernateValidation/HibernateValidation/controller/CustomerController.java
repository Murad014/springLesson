package com.HibernateValidation.HibernateValidation.controller;


import com.HibernateValidation.HibernateValidation.modelView.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String customerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer_form";
    }

    @PostMapping("/customer_confirm")
    public String customerConfirm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult
    ){

        if(bindingResult.hasErrors())
            return "customer_form";

        return "customer_confirm";

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);


    }




}
