package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record IdNumber(Long idNumber) {
    public IdNumber() {
        this(null);
    }

    public IdNumber {
        if (idNumber == null) throw new IllegalArgumentException("Id number cannot be null");
    }

    public Long getIdNumber() {
        return idNumber;
    }
}
