package com.techcompany.webservice.accountsManagement.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/*
 * Aggregate Identifier for Driver
 */
@Embeddable
public class DriverId implements Serializable {
    @Column(name = "driver_id")
    private Long driverId;
    public DriverId() {
    }
    public DriverId(Long driverId) {
        this.driverId = driverId;
    }
    public Long getDriverId() {
        return driverId;
    }
}
