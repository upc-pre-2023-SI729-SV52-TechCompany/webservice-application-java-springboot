package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateDriverCommand;

public interface DriverCommandService {
    Long handle(CreateDriverCommand command);

    Long handle(UpdateDriverCommand command);

    void handle(DeleteDriverCommand command);
}
