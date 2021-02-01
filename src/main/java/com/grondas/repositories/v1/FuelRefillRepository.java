package com.grondas.repositories.v1;

import com.grondas.domain.v1.FuelRefill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FuelRefillRepository extends JpaRepository<FuelRefill, Long>, JpaSpecificationExecutor<FuelRefill> {
}
