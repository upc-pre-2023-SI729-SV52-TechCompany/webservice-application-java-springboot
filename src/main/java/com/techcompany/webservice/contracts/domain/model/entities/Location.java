package com.techcompany.webservice.contracts.domain.model.entities;

import jakarta.persistence.Embeddable;

/*
 * Location class represented by a unique address
 */
@Embeddable
public class Location {
    private String address;

    public Location() {
    }

    public Location(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
