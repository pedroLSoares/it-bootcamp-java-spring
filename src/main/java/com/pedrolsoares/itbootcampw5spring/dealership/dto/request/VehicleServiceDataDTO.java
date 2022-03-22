package com.pedrolsoares.itbootcampw5spring.dealership.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleServiceDataDTO {

    private String date;
    private String kilometers;
    private String descriptions;
}
