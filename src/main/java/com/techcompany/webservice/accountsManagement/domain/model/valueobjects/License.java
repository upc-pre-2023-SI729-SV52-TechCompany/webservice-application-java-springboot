package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record License (String license) {
    public License() {
        this(null);
    }

    public License {
        if (license == null) {
            throw new IllegalArgumentException("License cannot be null");
        }
    }

    public String getLicense() {
        return license;
    }
}
