package com.pedrolsoares.itbootcampw5spring.romannumber.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversorService {

    public int convertRomanNumber(String roman){
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result=0;

        for(int i=0;i<roman.length();i++)
        {
            char currentChar = roman.charAt(i);

            if(i>0 && numbersMap.get(currentChar) > numbersMap.get(roman.charAt(i-1)))
            {
                result += numbersMap.get(currentChar) - 2 * numbersMap.get(roman.charAt(i-1));
            }

            else
                result += numbersMap.get(currentChar);
        }

        return result;
    }
}
