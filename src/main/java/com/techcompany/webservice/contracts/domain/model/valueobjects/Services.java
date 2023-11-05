package com.techcompany.webservice.contracts.domain.model.valueobjects;

public record Services(String service) {
    public Services {
        if (service == null || service.isBlank()) {
            throw new IllegalArgumentException("Service cannot be null or blank");
        }
    }

    public Services() {
        this(null);
    }

    public String getService() {
        return service;
    }
}
