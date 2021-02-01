package com.grondas.repositories.v1;

import com.grondas.domain.v1.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
