package com.pedrolsoares.itbootcampw5spring.conversor.controller;

import com.pedrolsoares.itbootcampw5spring.conversor.service.MorseConversorService;
import com.pedrolsoares.itbootcampw5spring.conversor.service.RomanConversorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/conversor")
public class ConversorController {

    private final RomanConversorService romanConversorService;
    private final MorseConversorService morseConversorService;


    @GetMapping("/roman/{number}")
    public String convertRomanNumber(@PathVariable int number){
        return romanConversorService.convertRomanNumber(number);
    }

    @GetMapping("/morse/{morse}")
    public String convertRomanNumber(@PathVariable String morse){
        return morseConversorService.convertMorseCode(morse);
    }

}
