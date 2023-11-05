package com.techcompany.webservice.contracts.domain.services;

import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;
import com.techcompany.webservice.contracts.interfaces.rest.resources.UpdateContractResource;

public interface ContractCommandService {
    Long handle(CreateContractCommand command);

    Long handle(UpdateContractResource command);

    void handle(DeleteContractResource command);
}
