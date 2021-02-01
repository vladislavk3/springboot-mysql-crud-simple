package com.grondas.web.v1.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO extends BaseDTO {

    private String driverName;
    private String odometer;

    private String driverUrl;

    @Override
    public String toString() {
        return  driverName ;
    }


}
