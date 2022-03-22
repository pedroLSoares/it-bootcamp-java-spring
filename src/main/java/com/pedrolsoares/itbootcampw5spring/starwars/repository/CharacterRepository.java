package com.pedrolsoares.itbootcampw5spring.starwars.repository;

import com.fasterxml.jackson.databind.*;
import com.pedrolsoares.itbootcampw5spring.starwars.model.Character;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {

    private final String DIRNAME = new File("src/main/java/com/pedrolsoares/itbootcampw5spring").getAbsolutePath();

    public List<Character> findAllByName(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(DIRNAME + "/starwars/files/starwars.json");

        return manualConverter(file, objectMapper, name);

    }

    private List<Character> dtoConverter(File file, ObjectMapper objectMapper, String name) throws IOException {
        Character[] result = objectMapper.readValue(file, Character[].class);


        return Arrays.stream(result).filter(c -> c.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    private List<Character> manualConverter(File file, ObjectMapper objectMapper, String name) throws IOException {
        Instant start2 = Instant.now();

        JsonNode jsonNode = objectMapper.readTree(file);

        List<Character> result = new ArrayList<>();
        jsonNode.forEach(c ->
                {
                    String height = c.get("height").asText().replace("NA", "0").replace(",", ".");
                    String mass = c.get("mass").asText().replace("NA", "0").replace(",", ".");

                    result.add(new Character(
                            c.get("name").asText(),
                            Double.valueOf(height).intValue(),
                            Double.valueOf(mass).intValue(),
                            c.get("hair_color").asText(),
                            c.get("skin_color").asText(),
                            c.get("eye_color").asText(),
                            c.get("birth_year").asText(),
                            c.get("gender").asText(),
                            c.get("homeworld").asText(),
                            c.get("species").asText()
                    ));
                }
        );

        Instant end2 = Instant.now();
        System.out.println("Elapsed Time in nano seconds for manualConverter: " + Duration.between(start2, end2));

        return result.stream()
                .filter(c -> c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());


    }

}
