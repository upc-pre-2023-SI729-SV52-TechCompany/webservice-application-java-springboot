package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Client;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllClientsQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetClientByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetClientByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ClientQueryService {
    Optional<Client> handle(GetClientByIdQuery query);
    Optional<Client> handle(GetClientByEmailQuery query);
    List<Client> handle(GetAllClientsQuery query);
}
