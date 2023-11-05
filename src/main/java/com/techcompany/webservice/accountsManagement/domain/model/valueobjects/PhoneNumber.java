package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record PhoneNumber(String phoneNumber) {
    public PhoneNumber() {
        this(null);
    }

    public PhoneNumber {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
