package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record PropertyDocument(String propertyDocument) {
    public PropertyDocument() {
        this(null);
    }

    public PropertyDocument {
        if (propertyDocument == null) {
            throw new IllegalArgumentException("PropertyDocument cannot be null");
        }
    }

    public String getPropertyDocument() {
        return propertyDocument;
    }
}
