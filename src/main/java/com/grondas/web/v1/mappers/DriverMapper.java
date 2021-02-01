package com.grondas.web.v1.mappers;

import com.grondas.domain.v1.Driver;
import com.grondas.web.v1.model.DriverDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface DriverMapper {

    DriverDTO objectToDTO(Driver driver);
    Driver dtoToObject(DriverDTO driverDTO);
}
