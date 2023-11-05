package com.techcompany.webservice.accountsManagement.application.internal.commandservices;

import com.techcompany.webservice.accountsManagement.domain.model.entities.Driver;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import com.techcompany.webservice.accountsManagement.domain.services.DriverCommandService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.DriverRepository;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DeleteDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateDriverResource;
import org.springframework.stereotype.Service;

@Service
public class DriverCommandServiceImpl implements DriverCommandService {
    private final DriverRepository driverRepository;

    public DriverCommandServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Long handle(CreateDriverResource command) {
        // Create a new driver
        Driver newDriver = new Driver(
                null,
                new EmailAddress(command.email()),
                new Password(command.password()),
                new PersonName(command.fullName()),
                new PhoneNumber(command.phone()),
                new Birthdate(command.birthdate()),
                new IdNumber(command.idNumber()),
                new Age(command.age()),
                new Country(command.country()),
                new Photo(command.photo()),
                new Job(command.job()),
                new TimeExperience(command.timeExperience()),
                new License(command.license()),
                new Soat(command.soat()),
                new PropertyDocument(command.propertyDocument()),
                new Certificate(command.certificate()),
                new PhotoVehicle(command.photoVehicle()),
                new Username(command.username()),
                new UserDescription(command.userDescription())
        );
        // Save the new driver
        Driver savedDriver = driverRepository.save(newDriver);
        // return ID of saved driver
        return savedDriver.getId();
    }

    @Override
    public Long handle(UpdateDriverResource command) {
        Driver existingDriver = driverRepository.findById(command.driverId()).orElse(null);
        // Check if the driver exists
        if (existingDriver != null){
            existingDriver.setEmail(new EmailAddress(command.email()));
            existingDriver.setPassword(new Password(command.password()));
            existingDriver.setFullName(new PersonName(command.fullName()));
            existingDriver.setPhone(new PhoneNumber(command.phone()));
            existingDriver.setBirthdate(new Birthdate(command.birthdate()));
            existingDriver.setIdNumber(new IdNumber(command.idNumber()));
            existingDriver.setAge(new Age(command.age()));
            existingDriver.setCountry(new Country(command.country()));
            existingDriver.setPhoto(new Photo(command.photo()));
            existingDriver.setJob(new Job(command.job()));
            existingDriver.setTimeExperience(new TimeExperience(command.timeExperience()));
            existingDriver.setLicense(new License(command.license()));
            existingDriver.setSoat(new Soat(command.soat()));
            existingDriver.setPropertyDocument(new PropertyDocument(command.propertyDocument()));
            existingDriver.setCertificate(new Certificate(command.certificate()));
            existingDriver.setPhotoVehicle(new PhotoVehicle(command.photoVehicle()));
            existingDriver.setUsername(new Username(command.username()));
            existingDriver.setUserDescription(new UserDescription(command.userDescription()));
            Driver updatedDriver = driverRepository.save(existingDriver);
            // return ID of updated driver
            return updatedDriver.getId();
        } else {
            throw new RuntimeException("Driver not found");
        }
    }

    @Override
    public Long handle(Long deleteDriverCommand) {
        Driver existingDriver = driverRepository.findById(deleteDriverCommand).orElse(null);
        if (existingDriver != null){
            driverRepository.deleteById(deleteDriverCommand);
            return existingDriver.getId();
        } else {
            throw new RuntimeException("Driver not found");
        }
    }


}
