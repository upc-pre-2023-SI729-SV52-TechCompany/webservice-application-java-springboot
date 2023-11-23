package com.techcompany.webservice.accountsManagement.interfaces.rest;

import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteDriverCommand;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllDriversQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetDriverByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.DriverCommandService;
import com.techcompany.webservice.accountsManagement.domain.services.DriverQueryService;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.CreateDriverFromResourceAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.DriverResourceFromEntityAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.UpdateDriverFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * REST Controller for managing driver-related operations in the accounts management module.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {
    private final DriverCommandService driverCommandService;
    private final DriverQueryService driverQueryService;

    /**
     * Constructs a new DriverController with the specified driver command and query services.
     *
     * @param driverCommandService The service for handling driver commands.
     * @param driverQueryService   The service for handling driver queries.
     */
    public DriverController(DriverCommandService driverCommandService, DriverQueryService driverQueryService) {
        this.driverCommandService = driverCommandService;
        this.driverQueryService = driverQueryService;
    }

    /**
     * Retrieves all drivers.
     *
     * @return A ResponseEntity containing a list of DriverResource objects.
     */
    @GetMapping
    public ResponseEntity<Iterable<DriverResource>> getAllDrivers() {
        var getAllDriversQuery = new GetAllDriversQuery();
        var drivers = driverQueryService.handle(getAllDriversQuery);
        var driverResources = drivers.stream()
                .map(DriverResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(driverResources);
    }

    /**
     * Retrieves a driver by ID.
     *
     * @param driverId The ID of the driver to retrieve.
     * @return A ResponseEntity containing the DriverResource if found, or a not found status if not found.
     */
    @GetMapping("/{driverId}")
    public ResponseEntity<DriverResource> getDriverById(@PathVariable Long driverId) {
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getDriverByIdQuery);
        if (driver.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return ResponseEntity.ok(driverResource);
    }

    /**
     * Creates a new driver.
     *
     * @param createDriverResource The resource containing driver creation details.
     * @return A ResponseEntity containing the created DriverResource, or a bad request status if creation fails.
     */
    @PostMapping
    public ResponseEntity<DriverResource> createDriver(@RequestBody CreateDriverResource createDriverResource) {
        var createDriverCommand = CreateDriverFromResourceAssembler.toCommandFromResource(createDriverResource);
        var driverId = driverCommandService.handle(createDriverCommand);
        if (driverId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getDriverByIdQuery);
        if (driver.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return new ResponseEntity<>(driverResource, HttpStatus.CREATED);
    }

    /**
     * Updates the details of an existing driver with the specified driver ID.
     *
     * @param driverId            The ID of the driver to be updated.
     * @param updateDriverResource The resource containing updated driver details.
     * @return A ResponseEntity containing the updated DriverResource if the update is successful,
     *         or a not found status if the driver with the specified ID is not found.
     */
    @PutMapping("/{driverId}")
    public ResponseEntity<DriverResource> updateDriver(@PathVariable Long driverId, @RequestBody UpdateDriverResource updateDriverResource) {
        var updateDriverCommand = UpdateDriverFromResourceAssembler.toCommandFromResource(driverId,updateDriverResource);
        var updateDriver = driverCommandService.handle(updateDriverCommand);
        if (updateDriver.isEmpty()) return ResponseEntity.notFound().build();
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(updateDriver.get());
        return ResponseEntity.ok(driverResource);

    }

    /**
     * Deletes a driver by ID.
     *
     * @param driverId The ID of the driver to delete.
     * @return A ResponseEntity with no content if deletion is successful.
     */
    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long driverId) {
        var deleteDriverCommand = new DeleteDriverCommand(driverId);
        driverCommandService.handle(deleteDriverCommand);
        return ResponseEntity.noContent().build();
    }
}

