package com.techcompany.webservice.accountsManagement.domain.model.aggregates;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
/*
 * Aggregate Identifier for Client
 */
@Embeddable
public class ClientId implements Serializable {
    private Long clientId;
    public ClientId() {
    }
    public ClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getClientId() {
        return clientId;
    }
}
