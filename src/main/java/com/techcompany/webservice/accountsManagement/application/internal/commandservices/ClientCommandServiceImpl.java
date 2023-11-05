package com.techcompany.webservice.accountsManagement.application.internal.commandservices;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateClienteCommand;
import com.techcompany.webservice.accountsManagement.domain.model.entities.Client;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import com.techcompany.webservice.accountsManagement.domain.services.ClientCommandService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientCommandServiceImpl implements ClientCommandService {
    private final ClientRepository clientRepository;

    public ClientCommandServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

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
                command.userDescription()
        );
        // Save the new client
        Client savedClient = clientRepository.save(newClient);
        // return ID of saved client
        return savedClient.getId();
    }

    @Override
    public Long handle(UpdateClienteCommand command) {
        // Get the client from the database
        Client existingClient = clientRepository.findById(command.clientId()).orElse(null);
        // Check if the client exists
        if (existingClient != null) {
            // Update the client fields
            existingClient.setEmail(command.email());
            existingClient.setPassword(command.password());
            existingClient.setFullName(command.fullName());
            existingClient.setPhone(command.phone());
            existingClient.setBirthdate(command.birthdate());
            existingClient.setIdNumber(command.idNumber());
            existingClient.setAge(command.age());
            existingClient.setCountry(command.country());
            existingClient.setPhoto(command.photo());
            existingClient.setUsername(command.username());
            existingClient.setUserDescription(command.userDescription());
            // Save the updated client
            Client savedClient = clientRepository.save(existingClient);
            // return ID of saved client
            return savedClient.getId();
        } else {
            // Manage the case where the client does not exist
            throw new RuntimeException("Client not found");
        }
    }

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
