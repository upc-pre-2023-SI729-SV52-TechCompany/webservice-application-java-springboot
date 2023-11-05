package com.techcompany.webservice.accountsManagement.application.internal.commandservices;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.commands.UpdateDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import com.techcompany.webservice.accountsManagement.domain.services.DriverCommandService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.DriverRepository;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;
import org.springframework.stereotype.Service;

@Service
public class DriverCommandServiceImpl implements DriverCommandService {
    private final DriverRepository driverRepository;

    public DriverCommandServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    @Override
    public Long handle(CreateDriverCommand command) {
        // Create a new driver
        Driver newDriver = new Driver(
                command.email(),
                command.password(),
                command.fullName(),
                command.phone(),
                command.birthdate(),
                command.idNumber(),
                command.age(),
                command.country(),
                command.photo(),
                command.job(),
                command.timeExperience(),
                command.license(),
                command.soat(),
                command.propertyDocument(),
                command.certificate(),
                command.photoVehicle(),
                command.username(),
                command.userDescription()
        );
        // Save the new driver
        Driver savedDriver = driverRepository.save(newDriver);
        // return ID of saved driver
        return savedDriver.getId();
    }

    @Override
    public Long handle(UpdateDriverCommand command) {
        Driver existingDriver = driverRepository.findById(command.driverId()).orElse(null);
        // Check if the driver exists
        if (existingDriver != null) {
            // Update the driver fields
            existingDriver.setEmail(command.email());
            existingDriver.setPassword(command.password());
            existingDriver.setFullName(command.fullName());
            existingDriver.setPhone(command.phone());
            existingDriver.setBirthdate(command.birthdate());
            existingDriver.setIdNumber(command.idNumber());
            existingDriver.setAge(command.age());
            existingDriver.setCountry(command.country());
            existingDriver.setPhoto(command.photo());
            existingDriver.setJob(command.job());
            existingDriver.setTimeExperience(command.timeExperience());
            existingDriver.setLicense(command.license());
            existingDriver.setSoat(command.soat());
            existingDriver.setPropertyDocument(command.propertyDocument());
            existingDriver.setCertificate(command.certificate());
            existingDriver.setPhotoVehicle(command.photoVehicle());
            existingDriver.setUsername(command.username());
            existingDriver.setUserDescription(command.userDescription());
            // Save the updated driver
            Driver savedDriver = driverRepository.save(existingDriver);
            // return ID of saved driver
            return savedDriver.getId();
        } else {
            // Manage the case where the driver does not exist
            throw new RuntimeException("Driver not found");
        }
    }

    @Override
    public Long handle(DeleteDriverCommand command) {
        Driver existingDriver = driverRepository.findById(command.driverId()).orElse(null);
        // Check if the driver exists
        if (existingDriver != null) {
            // Delete the driver
            driverRepository.delete(existingDriver);
            // return ID of deleted driver
            return existingDriver.getId();
        } else {
            // Manage the case where the driver does not exist
            throw new RuntimeException("Driver not found");
        }
    }
}
