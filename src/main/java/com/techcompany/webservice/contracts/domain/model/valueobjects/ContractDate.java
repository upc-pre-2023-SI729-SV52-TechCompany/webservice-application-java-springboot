package com.techcompany.webservice.contracts.domain.model.valueobjects;

import java.util.Date;

public record ContractDate(Date contractDate) {
    public ContractDate {
        if (contractDate == null) {
            throw new IllegalArgumentException("Contract date cannot be null");
        }
    }

    public ContractDate() {
        this(null);
    }

    public Date getContractDate() {
        return contractDate;
    }
}
