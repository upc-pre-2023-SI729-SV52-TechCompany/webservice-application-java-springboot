package com.techcompany.webservice.contracts.domain.model.valueobjects;

import java.util.Date;

public record ServiceDate(Date serviceDate) {
    public ServiceDate {
        if (serviceDate == null) {
            throw new IllegalArgumentException("Service date cannot be null or blank");
        }
    }

    public ServiceDate() {
        this(null);
    }

    public Date getServiceDate() {
        return serviceDate;
    }
}
