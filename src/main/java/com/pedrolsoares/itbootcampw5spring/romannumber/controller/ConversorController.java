package com.pedrolsoares.itbootcampw5spring.romannumber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedrolsoares.itbootcampw5spring.romannumber.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/conversor")
public class ConversorController {

    private final ConversorService conversorService;

    @Autowired
    public ConversorController(ConversorService conversorService) {
        this.conversorService = conversorService;
    }

    @GetMapping("/{romanNumber}")
    public int convertRomanNumber(@PathVariable String romanNumber){
        return conversorService.convertRomanNumber(romanNumber);
    }
}
