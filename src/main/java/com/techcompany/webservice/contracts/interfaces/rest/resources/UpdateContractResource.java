package com.techcompany.webservice.contracts.interfaces.rest.resources;

public record UpdateContractResource(
        Long contractId,
        Long driverId,
        Long clientId,
        String services,
        String origin,
        String destination,
        String serviceDate,
        String serviceTime,
        String cardNum,
        String cvvCard,
        String expireCard
) {
}
