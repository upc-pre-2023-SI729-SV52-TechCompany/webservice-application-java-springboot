package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Age(Integer age) {
    public Age() {
        this(0);
    }

    public Age {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public Integer getAge() {
        return age;
    }

}
