package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;

public class DriverResourceFromEntityAssembler {
    public static DriverResource toResourceFromEntity(Driver driver) {
        return new DriverResource(
                driver.getEmail(),
                driver.getPassword(),
                driver.getFullName(),
                driver.getPhone(),
                driver.getBirthdate(),
                driver.getAge(),
                driver.getIdNumber(),
                driver.getCountry(),
                driver.getPhoto(),
                driver.getJob(),
                driver.getTimeExperience(),
                driver.getLicense(),
                driver.getSoat(),
                driver.getPropertyDocument(),
                driver.getCertificate(),
                driver.getPhotoVehicle(),
                driver.getUsername(),
                driver.getUserDescription()
        );
    }
}
