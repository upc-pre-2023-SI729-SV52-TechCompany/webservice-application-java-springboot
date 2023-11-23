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

import java.util.Optional;

/**
 * Service implementation for handling driver-related commands in the accounts management module.
 * This service provides methods for creating, updating, and deleting driver entities.
 */
@Service
public class DriverCommandServiceImpl implements DriverCommandService {
    /**
     * The repository for accessing and manipulating driver entities in the database.
     */
    private final DriverRepository driverRepository;

    /**
     * Constructs a new DriverCommandServiceImpl with the specified driver repository.
     *
     * @param driverRepository The repository for driver entities.
     */

    public DriverCommandServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    /**
     * Handles the command to create a new driver.
     *
     * @param command The command containing driver creation details.
     * @return The ID of the newly created driver.
     */
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
                command.userDescription(),
                command.profileReview()
        );
        // Save the new driver
        Driver savedDriver = driverRepository.save(newDriver);
        // return ID of saved driver
        return savedDriver.getId();
    }

    /**
     * Handles the command to update an existing driver.
     *
     * @param command The command containing driver update details.
     * @return The ID of the updated driver.
     * @throws RuntimeException if the driver is not found.
     */
    @Override
    public Optional<Driver> handle(UpdateDriverCommand command) {
        if (!driverRepository.existsById(command.driverId())) {
            throw new IllegalArgumentException("Driver does not exist");
        }

        Driver drivertoUpdate = driverRepository.findById(command.driverId()).orElseThrow();

        drivertoUpdate.updateDriverInfo(
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
                command.userDescription(),
                command.profileReview()
        );
        Driver updateDriver = driverRepository.save(drivertoUpdate);
        return Optional.of(updateDriver);
    }

    /**
     * Handles the command to delete an existing driver.
     *
     * @param command The command containing driver deletion details.
     * @return The ID of the deleted driver.
     * @throws RuntimeException if the driver is not found.
     */
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
