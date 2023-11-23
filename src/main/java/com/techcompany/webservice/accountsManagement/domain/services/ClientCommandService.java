package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.entities.Client;

import java.util.Optional;

public interface ClientCommandService {
    Long handle(CreateClientCommand command);

    Optional<Client> handle(UpdateClientCommand command);

    void handle(DeleteClientCommand command);
}
