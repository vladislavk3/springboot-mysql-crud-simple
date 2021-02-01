package com.grondas.web.v1.mappers;

 import com.grondas.domain.v1.Client;
 import com.grondas.web.v1.model.ClientDTO;
 import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface ClientMapper {

    ClientDTO clientToClientDTO(Client client);
    Client clientDTOtoClient(ClientDTO clientDTO);

}
