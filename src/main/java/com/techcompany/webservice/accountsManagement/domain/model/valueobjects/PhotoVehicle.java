package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record PhotoVehicle(String photoVehicle) {
    public PhotoVehicle() {
        this(null);
    }

    public PhotoVehicle {
        if (photoVehicle == null) throw new IllegalArgumentException("PhotoVehicle cannot be null");
    }

    public String getPhotoVehicle() {
        return photoVehicle;
    }
}
