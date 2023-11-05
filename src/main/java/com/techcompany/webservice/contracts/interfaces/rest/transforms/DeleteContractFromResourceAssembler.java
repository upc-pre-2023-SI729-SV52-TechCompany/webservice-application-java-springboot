package com.techcompany.webservice.contracts.interfaces.rest.transforms;

import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;

public class DeleteContractFromResourceAssembler {
    public static DeleteContractResource toResourceFromEntity(Long contractId) {
        return new DeleteContractResource(contractId);
    }
}
