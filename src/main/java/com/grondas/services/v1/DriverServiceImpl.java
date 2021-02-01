package com.grondas.services.v1;

import com.grondas.domain.v1.Driver;
import com.grondas.repositories.v1.DriverRepository;
import com.grondas.web.v1.mappers.DriverMapper;
import com.grondas.web.v1.model.DriverDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DriverServiceImpl implements DriverService {

    ///////////////////// Injections /////////////////////

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverMapper driverMapper;

    ///////////////////// FIND METHODS /////////////////////

    @Override
    public List<DriverDTO> findAll() {
        return driverRepository
                .findAll()
                .stream()
                .map(driver -> {
                    DriverDTO driverDTO = driverMapper.objectToDTO(driver);
                  //  driverDTO.setDriverUrl(getUrl(driver.getId()));
                    return driverDTO;
                })
        .collect(Collectors.toList());
    }

    @Override
    public Driver findObjectById(Long id) {
        Optional<Driver> driverOptional = driverRepository.findById(id);

        if(!driverOptional.isPresent()) {
            throw new RuntimeException("Driver Not Found " + id);
        }
        return driverOptional.get();
    }

    @Override
    public DriverDTO findDtoById(Long id) {

        return driverMapper.objectToDTO(findObjectById(id));
    }

    ///////////////////// CREATE METHODS /////////////////////


    @Override
    public DriverDTO createNewObject(DriverDTO objectDTO) {

        Driver driver = driverMapper.dtoToObject(objectDTO);
        Driver savedDriver = driverRepository.save(driver);
        DriverDTO dto = driverMapper.objectToDTO(savedDriver);
//        dto.setDriverUrl(getUrl(savedDriver.getId()));
        return dto;
    }

    ///////////////////// DELETE METHODS /////////////////////


    @Override
    public void delete(DriverDTO objectDTO) {

    }

    @Override
    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }

    ///////////////////// SUPPORTIVE METHODS /////////////////////

    private String getUrl(Long id) {
        return null;
    }


}
