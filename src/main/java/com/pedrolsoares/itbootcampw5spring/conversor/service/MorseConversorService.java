package com.pedrolsoares.itbootcampw5spring.conversor.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseConversorService {

    public String convertMorseCode(String morse){
        Map<String,String> characterMap = new HashMap<>();
        characterMap.put("._", "A");
        characterMap.put("_...", "B");
        characterMap.put("_._.", "C");
        characterMap.put("_..", "D");
        characterMap.put(".", "E");
        characterMap.put(".._.", "F");
        characterMap.put("__.", "G");
        characterMap.put("....", "H");
        characterMap.put("..", "I");
        characterMap.put(".___", "J");
        characterMap.put("_._", "K");
        characterMap.put("._..", "L");
        characterMap.put("__", "M");
        characterMap.put("_.", "N");
        characterMap.put("___", "O");
        characterMap.put(".__.", "P");
        characterMap.put("__._", "Q");
        characterMap.put("._.", "R");
        characterMap.put("...", "S");
        characterMap.put("_", "T");
        characterMap.put(".._", "U");
        characterMap.put("..._", "V");
        characterMap.put(".__", "W");
        characterMap.put("_.._", "X");
        characterMap.put("_.__", "Y");
        characterMap.put("__..", "Z");
        characterMap.put("_____", "0");
        characterMap.put(".____", "1");
        characterMap.put("..___", "2");
        characterMap.put("...__", "3");
        characterMap.put("...._", "4");
        characterMap.put(".....", "5");
        characterMap.put("_....", "6");
        characterMap.put("__...", "7");
        characterMap.put("___..", "8");
        characterMap.put("____.", "9");
        characterMap.put("..__..", "?");
        characterMap.put("_._.__", "!");
        characterMap.put("._._._", ".");
        characterMap.put("__..__", ",");

        String[] splittedMorse = morse.split(" ");

        StringBuilder word = new StringBuilder();
        for(String code:splittedMorse){
            if(code.isEmpty()){
                word.append(" ");
                continue;
            }
            String charac = characterMap.get(code);
            word.append(charac);
        }

        return  word.toString();

    }
}
