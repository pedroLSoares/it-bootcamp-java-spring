package com.pedrolsoares.itbootcampw5spring.dealership.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleServiceModel {

    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
