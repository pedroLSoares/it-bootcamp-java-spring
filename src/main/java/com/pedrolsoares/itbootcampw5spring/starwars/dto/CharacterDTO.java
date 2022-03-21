package com.pedrolsoares.itbootcampw5spring.starwars.dto;

import com.pedrolsoares.itbootcampw5spring.starwars.model.Character;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public static List<CharacterDTO> entityToDTO(List<Character> characterList){
        return characterList.stream().map(c -> new CharacterDTO(
                c.getName(),
                c.getHeight(),
                c.getMass(),
                c.getGender(),
                c.getHomeworld(),
                c.getSpecies()
        )).collect(Collectors.toList());
    }

}
