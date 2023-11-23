package com.techcompany.webservice.accountsManagement.application.internal.queryservices;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllDriversQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetDriverByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetDriverByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.DriverQueryService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for handling driver queries in the accounts management module.
 * This service provides methods for retrieving driver information based on various queries.
 */
@Service
public class DriverQueryServiceImpl implements DriverQueryService {
    /**
     * The repository for accessing driver entities in the database.
     */
    private final DriverRepository driverRepository;

    /**
     * Constructs a new DriverQueryServiceImpl with the specified driver repository.
     *
     * @param driverRepository The repository for driver entities.
     */
    public DriverQueryServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    /**
     * Handles the query to retrieve a driver by its ID.
     *
     * @param query The query containing the driver ID.
     * @return An Optional containing the driver if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Driver> handle(GetDriverByIdQuery query) {
        return driverRepository.findById(query.driverId());
    }

    /**
     * Handles the query to retrieve a driver by its email address.
     *
     * @param query The query containing the driver email.
     * @return An Optional containing the driver if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Driver> handle(GetDriverByEmailQuery query) {
        return driverRepository.findByEmail(query.email());
    }

    /**
     * Handles the query to retrieve all drivers.
     *
     * @param query The query for retrieving all drivers.
     * @return A list of all drivers in the system.
     */
    @Override
    public List<Driver> handle(GetAllDriversQuery query) {
        return driverRepository.findAll();
    }


}
