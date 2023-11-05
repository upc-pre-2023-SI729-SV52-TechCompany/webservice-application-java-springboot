package com.techcompany.webservice.contracts.domain.model.commands;

import java.util.Date;

public record CreateContractCommand(
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
