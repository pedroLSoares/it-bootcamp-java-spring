package com.pedrolsoares.itbootcampw5spring.sports.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Athlete {
    private Person person;
    private Sport sport;
}
