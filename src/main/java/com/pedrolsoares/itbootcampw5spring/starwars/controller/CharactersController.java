package com.pedrolsoares.itbootcampw5spring.starwars.controller;

import com.pedrolsoares.itbootcampw5spring.starwars.dto.CharacterDTO;
import com.pedrolsoares.itbootcampw5spring.starwars.model.Character;
import com.pedrolsoares.itbootcampw5spring.starwars.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/starwars/characters")
public class CharactersController {

    private final CharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> findCharacterByName(@PathVariable String name){
        List<Character> characters = characterService.findAllByName(name);
        return new ResponseEntity<>(CharacterDTO.entityToDTO(characters), HttpStatus.OK);
    }
}
