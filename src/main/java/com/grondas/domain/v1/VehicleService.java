package com.grondas.domain.v1;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.grondas.services.v1.NotificationServiceImpl;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table
public class VehicleService extends BaseEntity {

    @Column
    private Timestamp serviceDate;

    @Column
    private String status;
    // that would be an Enum (Completed, Pending) when creating a new VehicleService, we would have to choose.
    // if that service is to be done, or it is already done

    @Column
    private String service;
    // Need to create serviceType Class Or The same as fuelStation Or Enum or ElementCollection
    // oilService, brakePadService, tyreChange, otherService, damageReport (mandatory to add an image, location)

    @Column
    private long serviceInterval;
    //every how many kilimoter we need to make the next service

    @Column
    private String ServiceDetails;

    @Column
    private long serviceNetCost;

    @Column
    private long serviceVatCost;

    @Column
    private long serviceTotalCost;

    @Column
    private long odometer;

    @Lob
    private String attachment;

    @ManyToOne
    @JoinColumn
    private Vehicle vehicle;
    //todo if Status Is Completed ---> do the following
    //todo Update Odometer field in Vehicle -> we need a entry variable for that
    //todo if Service = oilService, take the serviceInterval value and add it to the odometer and update the nextOilService kilometers -> we need a entry variable for that
    //todo if Service = brakePadService, take the serviceInterval value and add it to the odometer and update the e nextBrakePadService; kilometers -> we need a entry variable for that
    //todo if Service = TyreChange, take the serviceInterval value and add it to the the odometer and update nextTyreChange kilometers -> we need a entry variable for that
    //todo if status = pending create a method if vehicle.getOdometer -1,000 = odometer send an email (email method is already created)

}
