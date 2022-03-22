package com.pedrolsoares.itbootcampw5spring.dealership.service;

import com.pedrolsoares.itbootcampw5spring.dealership.model.Vehicle;
import com.pedrolsoares.itbootcampw5spring.dealership.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public UUID insertVehicle(Vehicle vehicle) {
            return vehicleRepository.insertOne(vehicle);
    }

    public List<Vehicle> findAllVehicles(){
        return vehicleRepository.findAll();
    }

    public List<Vehicle> findAllVehicles(LocalDate sinceParam, LocalDate toParam){
        return vehicleRepository.findAll(sinceParam, toParam);
    }

    public List<Vehicle> findAllVehicles(BigDecimal sinceParam, BigDecimal toParam){
        return vehicleRepository.findAll(sinceParam, toParam);
    }

    public Vehicle findById(String id){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByKey(UUID.fromString(id));

        if(optionalVehicle.isEmpty()){
            return null;
        }

        return optionalVehicle.get();
    }




}
