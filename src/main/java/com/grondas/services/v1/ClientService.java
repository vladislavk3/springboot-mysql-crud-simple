package com.grondas.services.v1;

import com.grondas.domain.v1.Client;
import com.grondas.web.v1.model.ClientDTO;

public interface ClientService extends BaseService<ClientDTO, Long> {

    Client findObjectById(long id);

}
