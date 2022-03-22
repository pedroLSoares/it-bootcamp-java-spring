package com.pedrolsoares.itbootcampw5spring.starwars.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedrolsoares.itbootcampw5spring.starwars.model.Character;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonUtils {

    private static final String DIRNAME = new File("src/main/java/com/pedrolsoares/itbootcampw5spring").getAbsolutePath();

    public  static <T> List<T> readJsonArray(String filePath, Class<T> cls){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(DIRNAME + filePath);


            JsonNode jsonNode = objectMapper.readTree(file);
            List<T> result = new ArrayList<>();

            return new ArrayList<>();

        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
