package com.techcompany.webservice.contracts.domain.services;

import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.DeleteContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.UpdateContractCommand;
import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;

public interface ContractCommandService {
    Long handle(CreateContractCommand command);

    Long handle(UpdateContractCommand command);

    void handle(DeleteContractCommand command);
}
