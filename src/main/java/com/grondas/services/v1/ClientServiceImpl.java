package com.grondas.services.v1;

import com.grondas.domain.v1.Client;
import com.grondas.repositories.v1.ClientRepository;
import com.grondas.web.v1.controllers.RestControllers.ClientRestController;
import com.grondas.web.v1.mappers.ClientMapper;
import com.grondas.web.v1.model.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
//@Profile({"jpaDTO", "default"})
public class ClientServiceImpl implements ClientService {

    ///////////////////// Injections /////////////////////

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    ///////////////////// CRUD METHODS /////////////////////

    @Override
    public List<ClientDTO> findAll() {

        return clientRepository
                .findAll()
                .stream()
                .map(client -> {
                    ClientDTO clientDTO = clientMapper.clientToClientDTO(client);
                    return clientDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Client findObjectById(long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(!clientOptional.isPresent()) {
            throw new RuntimeException("Client Not Found");
        }
        return clientOptional.get();
    }

    @Override
    public ClientDTO findDtoById(Long id) {

        return clientMapper.clientToClientDTO(findObjectById(id));
    }

    @Override
    public ClientDTO createNewObject(ClientDTO objectDTO) {
        Client client = clientMapper.clientDTOtoClient(objectDTO);
        Client savedClient = clientRepository.save(client);
        ClientDTO dto = clientMapper.clientToClientDTO(savedClient);
//        dto.setClientUrl(getUrl(savedClient.getId()));
        return dto;
    }


    @Override
    public void delete(ClientDTO object) {

    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    ///////////////////// SUPPORTIVE METHODS /////////////////////

    private String getClientUrl(Long id){
        return ClientRestController.BASE_URL + "/" + id;
    }

}
