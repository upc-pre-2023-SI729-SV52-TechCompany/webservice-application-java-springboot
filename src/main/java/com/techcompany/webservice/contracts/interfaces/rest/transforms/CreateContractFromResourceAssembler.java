package com.techcompany.webservice.contracts.interfaces.rest.transforms;

import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.interfaces.rest.resources.CreateContractResource;

public class CreateContractFromResourceAssembler {
    public static CreateContractCommand toCreateContractFromResource(CreateContractResource resource) {
        return new CreateContractCommand(
                resource.driverId(),
                resource.clientId(),
                resource.services(),
                resource.origin(),
                resource.destination(),
                resource.serviceDate(),
                resource.serviceTime(),
                resource.cardNum(),
                resource.cvvCard(),
                resource.expireCard()
        );
    }
}
