package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Client;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.ClientResource;

public class ClientResourceFromEntityAssembler {
    public static ClientResource toResourceFromEntity(Client client) {
        return new ClientResource(
                client.getEmail(),
                client.getPassword(),
                client.getFullName(),
                client.getPhone(),
                client.getBirthdate(),
                client.getIdNumber(),
                client.getAge(),
                client.getCountry(),
                client.getPhoto(),
                client.getUsername(),
                client.getUserDescription(),
                client.getProfileReview()
        );
    }
}
