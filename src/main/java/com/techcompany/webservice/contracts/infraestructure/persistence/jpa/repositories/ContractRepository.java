package com.techcompany.webservice.contracts.infraestructure.persistence.jpa.repositories;

import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findById(Long id);
}
