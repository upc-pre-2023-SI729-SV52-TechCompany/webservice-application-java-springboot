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
                null,
                new EmailAddress(command.email()),
                new Password(command.password()),
                new PersonName(command.fullName()),
                new PhoneNumber(command.phone()),
                new Birthdate(command.birthdate()),
                new IdNumber(command.idNumber()),
                new Age(command.age()),
                new Country(command.country()),
                new Photo(command.photo()),
                new Username(command.username()),
                new UserDescription(command.userDescription())
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
            existingClient.setEmail(new EmailAddress(command.email()));
            existingClient.setPassword(new Password(command.password()));
            existingClient.setFullName(new PersonName(command.fullName()));
            existingClient.setPhone(new PhoneNumber(command.phone()));
            existingClient.setBirthdate(new Birthdate(command.birthdate()));
            existingClient.setIdNumber(new IdNumber(command.idNumber()));
            existingClient.setAge(new Age(command.age()));
            existingClient.setCountry(new Country(command.country()));
            existingClient.setPhoto(new Photo(command.photo()));
            existingClient.setUsername(new Username(command.username()));
            existingClient.setUserDescription(new UserDescription(command.userDescription()));
            Client updatedClient = clientRepository.save(existingClient);
            // return ID of updated client
            return updatedClient.getId();
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
