package com.grondas.domain.v1;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Client extends BaseEntity {

    @Column(name = "client_name")
    private String clientName;


    //Create Element Collection to add preferred Operators for each client

//    @ElementCollection
//    @CollectionTable(name = "vehicle_refill", joinColumns = @JoinColumn(name = "id"))
//    @AttributeOverrides({@AttributeOverride(name = "fuelRefillLocation", column = @Column(name = "refill_location")),
//                         @AttributeOverride(name = "odometer", column = @Column(name = "odometer"))})
//    private List<FuelRefill> refills = new ArrayList<>();
}
