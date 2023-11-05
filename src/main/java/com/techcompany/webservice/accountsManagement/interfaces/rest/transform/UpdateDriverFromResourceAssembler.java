package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateDriverCommand;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateDriverResource;

public class UpdateDriverFromResourceAssembler {
    public static UpdateDriverResource toCommandFromResource(UpdateDriverResource resource) {
        return new UpdateDriverResource(
                resource.driverId(),
                resource.email(),
                resource.password(),
                resource.fullName(),
                resource.phone(),
                resource.birthdate(),
                resource.idNumber(),
                resource.age(),
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
