package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record PersonName(String fullname) {
    public PersonName() {
        this(null);
    }

    public PersonName{
        if (fullname == null) {
            throw new IllegalArgumentException("Fullname cannot be null");
        }
    }

    public String gelFullName() {
        return fullname;
    }
}
