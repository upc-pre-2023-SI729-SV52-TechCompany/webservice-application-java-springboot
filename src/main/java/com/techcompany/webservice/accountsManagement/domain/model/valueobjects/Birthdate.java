package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

import lombok.Getter;

import java.util.Date;

public record Birthdate(Date birthdate) {
    public Birthdate() {
        this(null);
    }

    public Birthdate {
        if (birthdate == null) throw new IllegalArgumentException("Birthdate cannot be null");
    }

    public Date getBirthdate() {
        return birthdate;
    }

}
