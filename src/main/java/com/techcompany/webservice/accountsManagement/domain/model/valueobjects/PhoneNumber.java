package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record PhoneNumber(Long phoneNumber) {
    public PhoneNumber() {
        this(null);
    }

    public PhoneNumber {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }
}
