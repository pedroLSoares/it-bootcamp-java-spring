package com.pedrolsoares.itbootcampw5spring.conversor.controller;

import com.pedrolsoares.itbootcampw5spring.conversor.service.RomanConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/conversor")
public class ConversorController {

    private final RomanConversorService romanConversorService;

    @Autowired
    public ConversorController(RomanConversorService romanConversorService) {
        this.romanConversorService = romanConversorService;
    }

    @GetMapping("/{number}")
    public String convertRomanNumber(@PathVariable int number){
        return romanConversorService.convertRomanNumber(number);
    }
}
