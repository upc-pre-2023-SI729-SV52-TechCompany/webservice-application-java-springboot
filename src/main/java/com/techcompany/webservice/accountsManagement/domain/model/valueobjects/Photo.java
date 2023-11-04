package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Photo(String photo) {
    public Photo() {
        this(null);
    }

    public Photo {
        if (photo == null) throw new IllegalArgumentException("Photo cannot be null");
    }

    public String getPhoto() {
        return photo;
    }
}
