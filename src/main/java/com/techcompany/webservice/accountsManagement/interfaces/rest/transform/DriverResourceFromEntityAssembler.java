package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;

public class DriverResourceFromEntityAssembler {
    public static DriverResource toResourceFromEntity(Driver driver) {
        return new DriverResource(driver.getId());
    }
}
