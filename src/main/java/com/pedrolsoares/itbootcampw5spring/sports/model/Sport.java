package com.pedrolsoares.itbootcampw5spring.sports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sport {

    private String name;
    private int level;
}
