package com.pedrolsoares.itbootcampw5spring.conversor.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseConversorService {

    public String convertMorseCode(String morse){
        Map<String,String> characterMap = new HashMap<>();
        characterMap.put("._", "A");
        characterMap.put("._", "B");
        characterMap.put("._", "C");
        characterMap.put("._", "D");
        characterMap.put("._", "E");
        characterMap.put("._", "F");
        characterMap.put("._", "G");
        characterMap.put("._", "H");

        return  "";

    }
}
