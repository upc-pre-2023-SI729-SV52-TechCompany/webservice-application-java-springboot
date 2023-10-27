package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record EmailAddress(String email) {
    public EmailAddress() {
        this(null);
    }

    public EmailAddress {
        if (email == null) throw new IllegalArgumentException("Email cannot be null");
    }

    public String getEmail() {
        return email;
    }
}
