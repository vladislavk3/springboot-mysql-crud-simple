package com.grondas.domain.v1;

import com.grondas.services.v1.NotificationServiceImpl;
import com.sendgrid.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Vehicle extends BaseEntity {

    @Column
    private String vehicleName;

    @Column
    private long odometer;

    @Column // it would save kilometers (100,000, 123,345 etc) change long to whatever you think better
    private long nextOilService;
    //todo create a method if odometer -1,000 = nextOilService send an email (email method already exists, i will send when i needed)

    @Column // it would save kilometers (100,000, 123,345 etc) change long to whatever you think better
    private long nextBrakePadService;

    @Column // it would save kilometers (100,000, 123,345 etc) change long to whatever you think better
    private long nextTyreChange;

    @OneToMany
    private List<VehicleService> services = new ArrayList<>();

}
