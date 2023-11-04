package com.techcompany.webservice.accountsManagement.application.internal.queryservices;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Client;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllClientsQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetClientByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetClientByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.ClientQueryService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {
    private final ClientRepository clientRepository;

    public ClientQueryServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> handle(GetClientByIdQuery query) {
        return clientRepository.findById(query.clientId());
    }

    @Override
    public Optional<Client> handle(GetClientByEmailQuery query) {
        return clientRepository.findByEmail(query.email());
    }

    @Override
    public List<Client> handle(GetAllClientsQuery query) {
        return clientRepository.findAll();
    }
}
