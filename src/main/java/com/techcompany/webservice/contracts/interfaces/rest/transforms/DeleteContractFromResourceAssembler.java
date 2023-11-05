package com.techcompany.webservice.contracts.interfaces.rest.transforms;

import com.techcompany.webservice.contracts.domain.model.commands.DeleteContractCommand;
import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;

public class DeleteContractFromResourceAssembler {
    public static DeleteContractCommand toResourceFromEntity(Long contractId) {
        return new DeleteContractCommand(contractId);
    }
}
