package com.techcompany.webservice.accountsManagement.application.internal.commandservices;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.entities.Client;
import com.techcompany.webservice.accountsManagement.domain.services.ClientCommandService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation for handling client-related commands in the accounts management module.
 * This service provides methods for creating, updating, and deleting client entities.
 */
@Service
public class ClientCommandServiceImpl implements ClientCommandService {
    /**
     * The repository for accessing and manipulating client entities in the database.
     */
    private final ClientRepository clientRepository;

    /**
     * Constructs a new ClientCommandServiceImpl with the specified client repository.
     *
     * @param clientRepository The repository for client entities.
     */
    public ClientCommandServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Handles the command to create a new client.
     *
     * @param command The command containing client creation details.
     * @return The ID of the newly created client.
     */
    @Override
    public Long handle(CreateClientCommand command) {
        // Create a new client
        Client newClient = new Client(
                command.email(),
                command.password(),
                command.fullName(),
                command.phone(),
                command.birthdate(),
                command.idNumber(),
                command.age(),
                command.country(),
                command.photo(),
                command.username(),
                command.userDescription(),
                command.profileReview()
        );
        // Save the new client
        Client savedClient = clientRepository.save(newClient);
        // return ID of saved client
        return savedClient.getId();
    }

    /**
     * Handles the command to update an existing client.
     *
     * @param command The command containing client update details.
     * @return The ID of the updated client.
     * @throws RuntimeException if the client is not found.
     */
    @Override
    public Optional<Client> handle(UpdateClientCommand command) {
        // Check if the client exists
        if (!clientRepository.existsById(command.clientId())) {
            throw new IllegalArgumentException("Client does not exist");
        }

        // Get the existing client from the database
        Client clientToUpdate = clientRepository.findById(command.clientId()).orElseThrow();

        // Update the client information
        clientToUpdate.updateClientInfo(
                command.email(),
                command.password(),
                command.fullName(),
                command.photo(),
                command.birthdate(),
                command.idNumber(),
                command.age(),
                command.country(),
                command.photo(),
                command.username(),
                command.userDescription(),
                command.profileReview()
        );

        // Save the updated client
        Client updatedClient = clientRepository.save(clientToUpdate);

        return Optional.of(updatedClient);
    }

    /**
     * Handles the command to delete an existing client.
     *
     * @param command The command containing client deletion details.
     * @throws RuntimeException if the client is not found.
     */
    @Override
    public void handle(DeleteClientCommand command) {
        Client existingClient = clientRepository.findById(command.clientId()).orElse(null);
        if (existingClient != null) {
            clientRepository.delete(existingClient);
        } else {
            // Manage the case where the client does not exist
            throw new RuntimeException("Client not found");
        }
    }
}
