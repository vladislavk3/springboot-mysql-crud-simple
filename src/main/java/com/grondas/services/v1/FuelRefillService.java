package com.grondas.services.v1;

import com.grondas.web.v1.model.FuelRefillDTO;

import java.util.List;

public interface FuelRefillService extends BaseService<FuelRefillDTO, Long> {

    public List<FuelRefillDTO> findAllByUserName();

}
