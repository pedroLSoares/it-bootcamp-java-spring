package com.pedrolsoares.itbootcampw5spring.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterJsonDTO {
    private String name;
    private String height;
    private String mass;
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


    public void setMass(String mass) {
        if(mass.equals("NA")){
            this.mass = "0";
            return;
        }
        this.mass = mass.replace(",", ".");
    }

    public void setHeight(String height) {
        if(height.equals("NA")){
            this.height = "0";
            return;
        }
        this.height = height.replace(",", ".");
    }
}
