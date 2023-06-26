package com.hibernate.hibernate.controller;


import com.hibernate.hibernate.data.jdbcTemplate.IngredientJdbcTemplateRepository;
import com.hibernate.hibernate.entity.Ingredient;
import com.hibernate.hibernate.entity.Ingredient.*;
import com.hibernate.hibernate.entity.Taco;
import com.hibernate.hibernate.entity.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@SessionAttributes("tacoOrder")
@RequestMapping("/design")
@Controller
public class TacoDesignController {
    private final IngredientJdbcTemplateRepository ingredientRepository;
    @Autowired
    public TacoDesignController(IngredientJdbcTemplateRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void sendIngreditentsToView(Model model){
        List<Ingredient> allIngredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(allIngredients::add);


        Type[] types = Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterTypes(allIngredients, type));
        }

    }

    @ModelAttribute("taco")
    public Taco taco(){
        return new Taco();
    }
    @ModelAttribute("tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }

    @GetMapping
    public String tacoForm(){
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {

        if(errors.hasErrors())
            return "design";

        log.info("Processing taco: {}", taco);
        tacoOrder.addTaco(taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterTypes(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(value -> value.getType().equals(type))
                .collect(Collectors.toList());

    }








}
