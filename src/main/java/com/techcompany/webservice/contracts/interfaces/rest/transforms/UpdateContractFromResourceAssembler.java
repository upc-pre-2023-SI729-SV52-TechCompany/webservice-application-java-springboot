package com.techcompany.webservice.contracts.interfaces.rest.transforms;

import com.techcompany.webservice.contracts.interfaces.rest.resources.UpdateContractResource;

public class UpdateContractFromResourceAssembler {
    public static UpdateContractResource toResourceFromEntity(UpdateContractResource resource) {
        return new UpdateContractResource(
                resource.contractId(),
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
