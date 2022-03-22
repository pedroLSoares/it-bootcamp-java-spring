package com.pedrolsoares.itbootcampw5spring.dealership.dto.response;

import com.pedrolsoares.itbootcampw5spring.dealership.dto.request.VehicleServiceDataDTO;
import com.pedrolsoares.itbootcampw5spring.dealership.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {

    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;

    public static List<VehicleResponseDTO> modelToDTO(List<Vehicle> vehicles){
        return vehicles.stream().map(v -> new VehicleResponseDTO(
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                v.getNumberOfKilometers().toString(),
                v.getDoors().toString(),
                v.getPrice().toString(),
                v.getCurrency(),
                v.getCountOfOwners().toString()
        )).collect(Collectors.toList());
    }
}
