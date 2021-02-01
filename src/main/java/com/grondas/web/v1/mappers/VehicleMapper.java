package com.grondas.web.v1.mappers;

import com.grondas.domain.v1.Vehicle;
import com.grondas.web.v1.model.VehicleDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface VehicleMapper {

    VehicleDTO objectToDTO (Vehicle vehicle);
    Vehicle dtoToObject(VehicleDTO vehicleDTO);



}
