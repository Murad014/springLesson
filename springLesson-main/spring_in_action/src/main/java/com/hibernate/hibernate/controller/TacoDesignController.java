package com.hibernate.hibernate.controller;


import com.hibernate.hibernate.entity.Ingredient;
import com.hibernate.hibernate.entity.Ingredient.*;
import com.hibernate.hibernate.entity.Taco;
import com.hibernate.hibernate.entity.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.Iterators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SessionAttributes("tacoOrder")
@RequestMapping("/design")
@Controller
public class TacoDesignController {

    @ModelAttribute
    public void sendIngreditentsToView(Model model){
        List<Ingredient> ingredients = new ArrayList<>(
                Arrays.asList(
                        new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                        new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                        new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                        new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                        new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                        new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                        new Ingredient("CHED", "Cheddar", Type.CHEESE),
                        new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                        new Ingredient("SLSA", "Salsa", Type.SAUCE),
                        new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
                )
        );

        Type[] types = Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterTypes(ingredients, type));

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
