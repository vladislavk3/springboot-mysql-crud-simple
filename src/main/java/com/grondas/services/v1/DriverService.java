package com.grondas.services.v1;

import com.grondas.domain.v1.Driver;
import com.grondas.web.v1.model.DriverDTO;

public interface DriverService extends BaseService<DriverDTO, Long> {

    Driver findObjectById(Long id);
}
