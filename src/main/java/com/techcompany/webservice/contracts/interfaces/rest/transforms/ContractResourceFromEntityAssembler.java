package com.techcompany.webservice.contracts.interfaces.rest.transforms;

import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import com.techcompany.webservice.contracts.interfaces.rest.resources.ContractResource;

public class ContractResourceFromEntityAssembler {
    public static ContractResource toResourceFromEntity(Contract contract) {
        return new ContractResource(
                contract.getDriverId(),
                contract.getClientId(),
                contract.getServices(),
                contract.getOrigin(),
                contract.getDestination(),
                contract.getServiceDate(),
                contract.getServiceTime(),
                contract.getCardNum(),
                contract.getCvvCard(),
                contract.getExpireCard()
        );
    }
}
