package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Username(String username) {
    public Username() {
        this(null);
    }

    public Username {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
    }

    public String getUsername() {
        return username;
    }
}
