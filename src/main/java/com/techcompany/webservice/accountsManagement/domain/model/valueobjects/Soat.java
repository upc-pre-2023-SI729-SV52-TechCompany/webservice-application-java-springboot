package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Soat(String soat) {
    public Soat() {
        this(null);
    }

    public Soat {
        if (soat == null) {
            throw new IllegalArgumentException("Soat cannot be null");
        }
    }

    public String getSoat() {
        return soat;
    }
}
