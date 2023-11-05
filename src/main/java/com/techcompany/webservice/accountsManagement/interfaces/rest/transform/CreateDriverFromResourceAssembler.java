package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;

public class CreateDriverFromResourceAssembler {
    public static CreateDriverResource toCommandFromResource(CreateDriverResource resource) {
        return new CreateDriverResource(
                resource.email(),
                resource.password(),
                resource.fullName(),
                resource.phone(),
                resource.birthdate(),
                resource.age(),
                resource.idNumber(),
                resource.country(),
                resource.photo(),
                resource.job(),
                resource.timeExperience(),
                resource.license(),
                resource.soat(),
                resource.propertyDocument(),
                resource.certificate(),
                resource.photoVehicle(),
                resource.username(),
                resource.userDescription()
        );
    }
}
