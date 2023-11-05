package com.techcompany.webservice.contracts.interfaces.rest.resources;

import java.util.Date;

public record CreateContractResource(
        Long driverId,
        Long clientId,
        String services,
        String origin,
        String destination,
        Date serviceDate,
        String serviceTime,
        String cardNum,
        String cvvCard,
        String expireCard
) {
}
