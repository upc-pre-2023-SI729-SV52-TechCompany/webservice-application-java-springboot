package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllDriversQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetDriverByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetDriverByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DriverQueryService {
    Optional<Driver> handle(GetDriverByIdQuery query);
    Optional<Driver> handle(GetDriverByEmailQuery query);
    List<Driver> handle(GetAllDriversQuery query);
}
