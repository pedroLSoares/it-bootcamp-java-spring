package com.pedrolsoares.itbootcampw5spring.dealership.dto.request;

import com.pedrolsoares.itbootcampw5spring.dealership.model.Vehicle;
import com.pedrolsoares.itbootcampw5spring.dealership.model.VehicleServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDataDTO {

    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<VehicleServiceDataDTO> services;
    private String countOfOwners;

    public static Vehicle dtoToModel(VehicleDataDTO vehicleDataDTO){
        List<VehicleServiceModel> serviceModels = vehicleDataDTO.getServices().stream().map(s -> new VehicleServiceModel(
                LocalDate.parse(s.getDate()),
                Integer.parseInt(s.getKilometers()),
                s.getDescriptions()
        )).collect(Collectors.toList());

        return new Vehicle(
                vehicleDataDTO.getBrand(),
                vehicleDataDTO.getModel(),
                LocalDate.parse(vehicleDataDTO.getManufacturingDate()),
                Integer.parseInt(vehicleDataDTO.getNumberOfKilometers()),
                Integer.parseInt(vehicleDataDTO.getDoors()),
                new BigDecimal(vehicleDataDTO.getPrice()),
                vehicleDataDTO.getCurrency(),
                serviceModels,
                Integer.parseInt(vehicleDataDTO.getCountOfOwners())
        );
    }

    public static VehicleDataDTO modelToDTO(Vehicle vehicle){
        List<VehicleServiceDataDTO> serviceDataDTOS = vehicle.getServices().stream().map(s ->
                new VehicleServiceDataDTO(
                        s.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        s.getKilometers().toString(),
                        s.getDescriptions()
                )).collect(Collectors.toList());

        return new VehicleDataDTO(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                vehicle.getNumberOfKilometers().toString(),
                vehicle.getDoors().toString(),
                vehicle.getPrice().toString(),
                vehicle.getCurrency(),
                serviceDataDTOS,
                vehicle.getCountOfOwners().toString()
        );
    }
}
