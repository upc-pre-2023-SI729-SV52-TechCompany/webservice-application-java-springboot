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

/**
 * Service implementation for handling client queries in the accounts management module.
 * This service provides methods for retrieving client information based on various queries.
 */
@Service
public class ClientQueryServiceImpl implements ClientQueryService {
    /**
     * The repository for accessing client entities in the database.
     */
    private final ClientRepository clientRepository;

    /**
     * Constructs a new ClientQueryServiceImpl with the specified client repository.
     *
     * @param clientRepository The repository for client entities.
     */
    public ClientQueryServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Handles the query to retrieve a client by its ID.
     *
     * @param query The query containing the client ID.
     * @return An Optional containing the client if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Client> handle(GetClientByIdQuery query) {
        return clientRepository.findById(query.clientId());
    }

    /**
     * Handles the query to retrieve a client by its email address.
     *
     * @param query The query containing the client email.
     * @return An Optional containing the client if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Client> handle(GetClientByEmailQuery query) {
        return clientRepository.findByEmail(query.email());
    }

    /**
     * Handles the query to retrieve all clients.
     *
     * @param query The query for retrieving all clients.
     * @return A list of all clients in the system.
     */
    @Override
    public List<Client> handle(GetAllClientsQuery query) {
        return clientRepository.findAll();
    }
}
