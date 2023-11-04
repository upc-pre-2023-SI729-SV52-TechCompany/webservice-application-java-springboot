package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateClienteCommand;

public interface ClientCommandService {
    Long handle(CreateClientCommand command);

    Long handle(UpdateClienteCommand command);

    void handle(DeleteClientCommand command);
}
