package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;

import java.util.Optional;

public interface DriverCommandService {
    Long handle(CreateDriverCommand command);

    Optional<Driver> handle(UpdateDriverCommand command);

    Long handle(DeleteDriverCommand command);
}
