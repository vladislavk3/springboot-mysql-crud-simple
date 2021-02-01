package com.grondas.web.v1.mappers;

import com.grondas.domain.v1.FuelRefill;
import com.grondas.web.v1.model.FuelRefillDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface FuelRefillMapper {

    FuelRefillDTO objectToDTO(FuelRefill fuelRefill);
    FuelRefill dtoToObject(FuelRefillDTO fuelRefillDTO);



}
