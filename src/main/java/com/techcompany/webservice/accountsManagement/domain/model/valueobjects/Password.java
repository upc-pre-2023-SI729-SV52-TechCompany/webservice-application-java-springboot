package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Password(String password) {
    public Password() {
        this(null);
    }

    public Password {
        if (password == null) throw new IllegalArgumentException("Password cannot be null");
    }

    public String getPassword() {
        return password;
    }
}
