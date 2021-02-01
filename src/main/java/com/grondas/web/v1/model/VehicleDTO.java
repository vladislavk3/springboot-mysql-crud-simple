package com.grondas.web.v1.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO extends BaseDTO {

    private String vehicleName;
    private long odometer;
    private String vehicleUrl;


    @Override
    public String toString() {
        return vehicleName;
    }
}
