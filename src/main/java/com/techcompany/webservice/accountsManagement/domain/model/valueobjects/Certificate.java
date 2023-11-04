package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Certificate(String certificate) {
    public Certificate() {
        this(null);
    }

    public Certificate {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate cannot be null");
        }
    }

    public String getCertificate() {
        return certificate;
    }
}
