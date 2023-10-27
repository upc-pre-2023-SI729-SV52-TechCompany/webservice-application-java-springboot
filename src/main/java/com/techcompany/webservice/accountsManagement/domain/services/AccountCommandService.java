package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateAccountCommand;

public interface AccountCommandService {
    Long handle(CreateAccountCommand command);
}
