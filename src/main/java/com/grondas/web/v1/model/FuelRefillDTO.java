package com.grondas.web.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuelRefillDTO extends BaseDTO {

    private long refillTotalPrice;
    private long refillLiters;
    private long odometer;
    private String fuelRefillLocation;

    private DriverDTO driver;
    private VehicleDTO vehicle;
}
