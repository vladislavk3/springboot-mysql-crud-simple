package com.grondas.services.v1;

import com.grondas.domain.v1.Driver;
import com.grondas.domain.v1.FuelRefill;
import com.grondas.repositories.v1.FuelRefillRepository;
import com.grondas.security.AuthenticationFacade;
import com.grondas.web.v1.mappers.FuelRefillMapper;
import com.grondas.web.v1.model.FuelRefillDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FuelRefillServiceImpl implements FuelRefillService {

    public static double VAT_PERCENTAGE_RATE = 0.19;

    ///////////////////// Injections /////////////////////

        @Autowired
        private FuelRefillRepository fuelRefillRepository;
        @Autowired
        private FuelRefillMapper fuelRefillMapper;
        
        private AuthenticationFacade authenticationFacade;


    @Override
    public List<FuelRefillDTO> findAll() {

        return fuelRefillRepository
                .findAll()
                .stream()
                .map(refill -> {
                    FuelRefillDTO dto = fuelRefillMapper.objectToDTO(refill);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<FuelRefillDTO> findAllByUserName() {

      return null;
    }

    @Override
    public FuelRefillDTO findDtoById(Long aLong) {
        return null;
    }

    @Override
    public FuelRefillDTO createNewObject(FuelRefillDTO objectDTO) {

        FuelRefill refill = fuelRefillMapper.dtoToObject(objectDTO);
        FuelRefill savedRefill = fuelRefillRepository.save(refill);
        FuelRefillDTO dto = fuelRefillMapper.objectToDTO(savedRefill);
        return dto;
    }

    @Override
    public void delete(FuelRefillDTO objectDTO) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    ///////////////////// SUPPORTIVE METHODS /////////////////////

    private String getUrl(Long id) {
        return null;
    }


    public static double getRefillNetPrice(long refillTotalPrice){
       return refillTotalPrice/(1+ VAT_PERCENTAGE_RATE);
    }
}
