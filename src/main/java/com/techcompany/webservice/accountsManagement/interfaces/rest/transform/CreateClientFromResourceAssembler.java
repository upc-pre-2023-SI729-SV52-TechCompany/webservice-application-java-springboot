package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateClientCommand;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateClientResource;

public class CreateClientFromResourceAssembler {
    public static CreateClientCommand toCommandFromResource(CreateClientResource resource) {
        return new CreateClientCommand(
                resource.email(),
                resource.password(),
                resource.fullName(),
                resource.phone(),
                resource.birthdate(),
                resource.idNumber(),
                resource.age(),
                resource.country(),
                resource.photo(),
                resource.username(),
                resource.userDescription(),
                resource.profileReview()
        );
    }
}
