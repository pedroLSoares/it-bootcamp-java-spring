package com.pedrolsoares.itbootcampw5spring.conversor.service;


import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalculatorService {

    public Long calculateAgeByBirth(Integer day, Integer month, Integer year){

            LocalDate birthDate= LocalDate.of(year, month, day);
            return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
