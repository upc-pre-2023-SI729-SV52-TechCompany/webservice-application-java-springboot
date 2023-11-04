package com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByEmail(EmailAddress email);
}
