package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Country(String country) {
    public Country() {
        this(null);
    }

    public Country {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
    }

    public String getCountry() {
        return country;
    }
}
