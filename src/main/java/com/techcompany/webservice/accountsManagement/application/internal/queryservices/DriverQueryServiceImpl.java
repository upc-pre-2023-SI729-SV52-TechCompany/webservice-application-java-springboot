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

@Service
public class DriverQueryServiceImpl implements DriverQueryService {
    private final DriverRepository driverRepository;

    public DriverQueryServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Optional<Driver> handle(GetDriverByIdQuery query) {
        return driverRepository.findById(query.driverId());
    }

    @Override
    public Optional<Driver> handle(GetDriverByEmailQuery query) {
        return driverRepository.findByEmail(query.email());
    }

    @Override
    public List<Driver> handle(GetAllDriversQuery query) {
        return driverRepository.findAll();
    }


}
