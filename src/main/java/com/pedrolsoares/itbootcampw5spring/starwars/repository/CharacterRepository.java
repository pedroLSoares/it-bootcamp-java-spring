package com.pedrolsoares.itbootcampw5spring.starwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedrolsoares.itbootcampw5spring.starwars.dto.CharacterJsonDTO;
import com.pedrolsoares.itbootcampw5spring.starwars.model.Character;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {

    private final String DIRNAME = new File("src/main/java/com/pedrolsoares/itbootcampw5spring").getAbsolutePath();

    public List<Character> findAllByName(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        CharacterJsonDTO[] JsonCharacters = objectMapper.readValue(new File(DIRNAME + "/starwars/files/starwars.json"), CharacterJsonDTO[].class);
        return Arrays.stream(JsonCharacters)
                .filter(c -> c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .map(c -> new Character(
                c.getName(),
                Double.valueOf(c.getHeight()).intValue(),
                Double.valueOf(c.getMass()).intValue(),
                c.getHairColor(),
                c.getSkinColor(),
                c.getEyeColor(),
                c.getBirthYear(),
                c.getGender(),
                c.getHomeworld(),
                c.getSpecies()
        )).collect(Collectors.toList());

    }
}
