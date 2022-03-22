package com.pedrolsoares.itbootcampw5spring.dealership.repository;

import com.pedrolsoares.itbootcampw5spring.dealership.exception.RegisterAlreadyExistsException;
import com.pedrolsoares.itbootcampw5spring.dealership.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements RepositoryInterface<Vehicle, UUID>{

    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public UUID insertOne(Vehicle vehicle) {
        UUID id = UUID.randomUUID();
        if(vehicles.contains(vehicle)){
            throw new RegisterAlreadyExistsException("Veículo já existente na base de dados");
        }

        vehicle.setID(id);

        vehicles.add(vehicle);

        return id;

    }

    @Override
    public boolean update(UUID id, Vehicle data) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return vehicles.removeIf(v -> v.getID().equals(id));
    }

    @Override
    public List<Vehicle> findAll(){
        return vehicles;
    }

    public List<Vehicle> findAll(LocalDate sinceDate, LocalDate toDate){
        return vehicles.stream().filter(v -> v.getManufacturingDate().isAfter(sinceDate) && v.getManufacturingDate().isBefore(toDate)).collect(Collectors.toList());
    }


    public List<Vehicle> findAll(BigDecimal sincePrice, BigDecimal toPrice){
        return vehicles.stream().filter(v -> v.getPrice().compareTo(sincePrice) > 0 && v.getPrice().compareTo(toPrice) < 0).collect(Collectors.toList());
    }

    @Override
    public Optional<Vehicle> findByKey(UUID key){
        return vehicles.stream().filter(v -> v.getID().equals(key)).findFirst();
    }
}
