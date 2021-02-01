package com.grondas.services.v1;

import com.grondas.domain.v1.Driver;
import com.grondas.domain.v1.Vehicle;
import com.grondas.web.v1.model.VehicleDTO;

public interface VehicleService extends BaseService<VehicleDTO, Long> {

    Vehicle findObjectById(Long id);


}
