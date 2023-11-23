package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateClientCommand;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateClientResource;

public class UpdateClientFromResourceAssembler {
    public static UpdateClientCommand toCommandFromResource(Long clientId,UpdateClientResource resource){
        return new UpdateClientCommand(
                clientId,
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
