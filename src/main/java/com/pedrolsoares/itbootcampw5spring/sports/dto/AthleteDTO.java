package com.pedrolsoares.itbootcampw5spring.sports.dto;

import com.pedrolsoares.itbootcampw5spring.sports.model.Athlete;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AthleteDTO implements Serializable {

    private String name;
    private String lastName;
    private String sportName;

    public static List<AthleteDTO> modelToDTO(List<Athlete> athleteList){
        return athleteList.stream().map(athlete -> new AthleteDTO(
                athlete.getPerson().getName(),
                athlete.getPerson().getLastName(),
                athlete.getSport().getName()
        )).collect(Collectors.toList());
    }
}
