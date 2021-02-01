package com.grondas.web.v1.controllers.RestControllers;

import com.grondas.services.v1.ClientService;
import com.grondas.web.v1.model.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ClientRestController.BASE_URL)
public class ClientRestController {

    public static final String BASE_URL = "/api/v1/client";
    @Autowired
    private ClientService clientService;

    //  ============= Rest Mappings =============

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO createNewObject(@RequestBody @Validated ClientDTO clientDTO) {
        return clientService.createNewObject(clientDTO);
    }
}
