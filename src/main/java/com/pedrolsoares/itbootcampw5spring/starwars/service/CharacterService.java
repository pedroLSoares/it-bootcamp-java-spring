package com.pedrolsoares.itbootcampw5spring.starwars.service;

import com.pedrolsoares.itbootcampw5spring.starwars.model.Character;
import com.pedrolsoares.itbootcampw5spring.starwars.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public List<Character> findAllByName(String name){
        try {
            return characterRepository.findAllByName(name);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }


}
