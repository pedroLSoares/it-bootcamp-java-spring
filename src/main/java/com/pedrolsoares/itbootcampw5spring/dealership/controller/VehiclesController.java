package com.pedrolsoares.itbootcampw5spring.dealership.controller;

import com.pedrolsoares.itbootcampw5spring.dealership.dto.request.VehicleDataDTO;
import com.pedrolsoares.itbootcampw5spring.dealership.dto.response.VehicleResponseDTO;
import com.pedrolsoares.itbootcampw5spring.dealership.model.Vehicle;
import com.pedrolsoares.itbootcampw5spring.dealership.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/dealership/v1/api/vehicles")
public class VehiclesController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> insertVehicle(@RequestBody VehicleDataDTO vehicle, UriComponentsBuilder uriComponentsBuilder){
        UUID id = vehicleService.insertVehicle(VehicleDataDTO.dtoToModel(vehicle));

        if(id == null){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

        URI uri = uriComponentsBuilder
                .path("/dealership/v1/api/vehicles/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(uri).body(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> findAll(){
        List<Vehicle> vehicles = vehicleService.findAllVehicles();

        return new ResponseEntity<>(VehicleResponseDTO.modelToDTO(vehicles), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDataDTO> findById(@PathVariable String id){
        Vehicle vehicle = vehicleService.findById(id);

        return new ResponseEntity<>(VehicleDataDTO.modelToDTO(vehicle), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDTO>> findAllByDate(@RequestParam String since, @RequestParam String to){
        List<Vehicle> vehicles =  vehicleService.findAllVehicles(LocalDate.parse(since), LocalDate.parse(to));

        return new ResponseEntity<>(VehicleResponseDTO.modelToDTO(vehicles), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDTO>> findAllByPrices(@RequestParam String since, @RequestParam String to){
        List<Vehicle> vehicles =  vehicleService.findAllVehicles(new BigDecimal(since), new BigDecimal(to));

        return new ResponseEntity<>(VehicleResponseDTO.modelToDTO(vehicles), HttpStatus.OK);
    }


}
