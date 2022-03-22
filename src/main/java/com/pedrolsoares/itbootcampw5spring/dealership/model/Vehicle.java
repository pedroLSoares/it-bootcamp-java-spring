package com.pedrolsoares.itbootcampw5spring.dealership.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private UUID ID;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private BigDecimal price;
    private String currency;
    private List<VehicleServiceModel> services;
    private Integer countOfOwners;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, Integer numberOfKilometers, Integer doors, BigDecimal price, String currency, List<VehicleServiceModel> services, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

}
