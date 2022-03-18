package com.pedrolsoares.itbootcampw5spring.conversor.controller;

import com.pedrolsoares.itbootcampw5spring.conversor.service.CalculatorService;
import com.pedrolsoares.itbootcampw5spring.conversor.service.MorseConversorService;
import com.pedrolsoares.itbootcampw5spring.conversor.service.RomanConversorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/conversor")
public class ConversorController {

    private final RomanConversorService romanConversorService;
    private final MorseConversorService morseConversorService;
    private final CalculatorService calculatorService;


    @GetMapping("/roman/{number}")
    public String convertRomanNumber(@PathVariable int number){
        return romanConversorService.convertRomanNumber(number);
    }

    @GetMapping("/morse/{morse}")
    public String convertRomanNumber(@PathVariable String morse){
        return morseConversorService.convertMorseCode(morse);
    }

    @GetMapping("/age/{day}/{month}/{year}")
    public ResponseEntity<?> calculateAge(@PathVariable Map<String, String> birth){

            Long diff = calculatorService.calculateAgeByBirth(
                    Integer.parseInt(birth.get("day")),
                    Integer.parseInt(birth.get("month")),
                    Integer.parseInt(birth.get("year")));
            return new ResponseEntity<>(diff, HttpStatus.OK);


    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> handleNumberFormat(){
        return new ResponseEntity<>("Ceritifque-se se os dados foram passados no formato correto", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>("Alguma coisa deu errado, tente novamente mais tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
