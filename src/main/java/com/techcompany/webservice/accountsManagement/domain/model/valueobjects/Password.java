package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Password(String password) {

    public Password {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        else if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
    public Password() {
        this(null);
    }

    public String getPassword() {
        return password;
    }
}
