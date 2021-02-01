package com.grondas.services.v1;

import com.grondas.domain.v1.Vehicle;
import com.grondas.repositories.v1.VehicleRepository;
import com.grondas.web.v1.mappers.VehicleMapper;
import com.grondas.web.v1.model.VehicleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    ///////////////////// Injections /////////////////////
    
	@Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleMapper vehicleMapper;


    
    public List<VehicleDTO> findAll() {
        return vehicleRepository
                .findAll()
                .stream()
                .map(vehicle -> {
                    VehicleDTO dto = vehicleMapper.objectToDTO(vehicle);
                   // dto.setVehicleUrl(getUrl(vehicle.getId()));
                    return dto;
                })
        .collect(Collectors.toList());
    }
    @Override
    public Vehicle findObjectById(Long id) {

        Optional<Vehicle> optional = vehicleRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RuntimeException("Vehicle Not Found " + id);
        }
        return optional.get();
    }

    @Override
    public VehicleDTO findDtoById(Long id) {

        return vehicleMapper.objectToDTO(findObjectById(id));
    }

    @Override
    public VehicleDTO createNewObject(VehicleDTO objectDTO) {

        Vehicle vehicle = vehicleMapper.dtoToObject(objectDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        VehicleDTO dto = vehicleMapper.objectToDTO(savedVehicle);
        return dto;
    }

    @Override
    public void delete(VehicleDTO objectDTO) {

    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }

    ///////////////////// SUPPORTIVE METHODS /////////////////////

    private String getUrl(Long id) {
        return null;
    }

}
