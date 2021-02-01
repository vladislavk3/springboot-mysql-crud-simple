package com.grondas.domain.v1;

import com.grondas.services.v1.FuelRefillServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class FuelRefill extends BaseEntity {

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Driver driver;

    @Column
    private long refillTotalPrice;

    @Column
    private double refillNetPrice; //Changed this to double because of the division operation
    //todo crate calculation refillTotalPrice / 1 + vat percentage rate

    @Column
    private double refillVatPrice; //Changed this to double because of the division operation
    //todo refillTotalPrice * vat percentage rate


    @Column
    private long refillLiters;

    @Column
    private long odometer;
    //todo update the odometer into Vehicle Column

    @Column
    private String fuelRefillLocation;
    //todo confing that in front end with pre-fill texts to store in string (check pic) - we will set it later in Angular

    @Column
    private long consumption;
    //todo retrieve odometer from last created FuelRefill,
    // String kilometer = (odometer (the one addeded now) - vehicle odometer(the last created refill)) / 100;
    // refillLiters / kilometer = consumption -> save it to database


}
