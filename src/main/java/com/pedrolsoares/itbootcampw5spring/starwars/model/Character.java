package com.pedrolsoares.itbootcampw5spring.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character implements Serializable {

    private String name;
    private Integer height;
    private Integer mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public void setHeight(Object height) {
        this.height = (Integer) height;
    }

    public void setMass(Object mass) {
        this.mass = (Integer) mass;
    }
}
