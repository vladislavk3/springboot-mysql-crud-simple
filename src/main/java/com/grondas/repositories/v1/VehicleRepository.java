package com.grondas.repositories.v1;

import com.grondas.domain.v1.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
