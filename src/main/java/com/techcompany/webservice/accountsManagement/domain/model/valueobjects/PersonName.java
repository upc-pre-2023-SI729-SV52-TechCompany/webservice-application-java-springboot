package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record PersonName(String fullName) {
    public PersonName() {
        this(null);
    }

    public PersonName{
        if (fullName == null) {
            throw new IllegalArgumentException("Fullname cannot be null");
        }
    }

    public String getFullName() {
        return fullName;
    }
}
