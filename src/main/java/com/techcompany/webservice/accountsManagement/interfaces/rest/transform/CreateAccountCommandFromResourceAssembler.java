package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateAccountCommand;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateAccountResource;

public class CreateAccountCommandFromResourceAssembler {
    public static CreateAccountCommand toCommandFromResource(CreateAccountResource resource){
        return new CreateAccountCommand(
                resource.name(),
                resource.email(),
                resource.country(),
                resource.birthday(),
                resource.phonenumber(),
                resource.username(),
                resource.password()
        );
    }
}
