package com.techcompany.webservice.contracts.domain.model.valueobjects;

public record ServiceTime(String serviceTime) {
    public ServiceTime {
        if (serviceTime == null || serviceTime.isBlank()) {
            throw new IllegalArgumentException("Service time cannot be null or blank");
        }
    }

    public ServiceTime() {
        this(null);
    }

    public String getServiceTime() {
        return serviceTime;
    }
}
