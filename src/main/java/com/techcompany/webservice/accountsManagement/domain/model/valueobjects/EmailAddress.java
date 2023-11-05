package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record EmailAddress(String email) {
    public EmailAddress() {
        this(null);
    }

    public EmailAddress {
        if (email == null) throw new IllegalArgumentException("Email cannot be null");
        // validate email
        else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) throw new IllegalArgumentException("Email is not valid");
    }

    public String getEmail() {
        return email;
    }
}
