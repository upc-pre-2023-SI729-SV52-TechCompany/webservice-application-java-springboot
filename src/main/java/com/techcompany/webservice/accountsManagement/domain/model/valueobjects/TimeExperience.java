package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record TimeExperience(String timeExperience) {
    public TimeExperience() {
        this(null);
    }

    public TimeExperience {
        if (timeExperience == null) {
            throw new IllegalArgumentException("TimeExperience cannot be null");
        }
    }

    public String getTimeExperience() {
        return timeExperience;
    }
}
