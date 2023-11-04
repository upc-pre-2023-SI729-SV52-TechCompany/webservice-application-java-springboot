package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record UserDescription(String userDescription) {
    public UserDescription() {
        this(null);
    }

    public UserDescription {
        if (userDescription == null) throw new IllegalArgumentException("UserDescription cannot be null");
    }

    public String getUserDescription() {
        return userDescription;
    }
}
