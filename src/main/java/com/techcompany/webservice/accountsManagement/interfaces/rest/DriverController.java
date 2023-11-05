package com.techcompany.webservice.accountsManagement.interfaces.rest;

import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllDriversQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetDriverByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.DriverCommandService;
import com.techcompany.webservice.accountsManagement.domain.services.DriverQueryService;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DeleteDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.CreateDriverFromResourceAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.DeleteDriverFromResourceAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.DriverResourceFromEntityAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.UpdateDriverFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/drivers")
public class DriverController {
    private final DriverCommandService driverCommandService;
    private final DriverQueryService driverQueryService;

    public DriverController(DriverCommandService driverCommandService, DriverQueryService driverQueryService) {
        this.driverCommandService = driverCommandService;
        this.driverQueryService = driverQueryService;
    }

    @GetMapping
    public ResponseEntity<Iterable<DriverResource>> getAllDrivers() {
        var getAllDriversQuery = new GetAllDriversQuery();
        var drivers = driverQueryService.handle(getAllDriversQuery);
        var driverResources = drivers.stream()
                .map(DriverResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(driverResources);
    }

    @GetMapping
    @RequestMapping(value = "/{driverId}")
    public ResponseEntity<DriverResource> getDriverById(@PathVariable Long driverId) {
        var getDriverByIdQuery = new GetDriverByIdQuery(driverId);
        var driver = driverQueryService.handle(getDriverByIdQuery);
        if (driver.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var driverResource = DriverResourceFromEntityAssembler.toResourceFromEntity(driver.get());
        return ResponseEntity.ok(driverResource);
    }

    @PostMapping
    @RequestMapping(value = "/create")
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

    @PutMapping
    @RequestMapping(value = "/update")
    public ResponseEntity<DriverResource> updateDriver(@RequestBody UpdateDriverResource updateDriverResource) {
        var updateDriverCommand = UpdateDriverFromResourceAssembler.toCommandFromResource(updateDriverResource);
        var driverId = driverCommandService.handle(updateDriverCommand);
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

    @DeleteMapping
    @RequestMapping(value = "/delete")
    public ResponseEntity<DriverResource> deleteDriver(@RequestBody DeleteDriverResource deleteDriverResource) {
        var deleteDriverCommand = DeleteDriverFromResourceAssembler.toCommandFromResource(deleteDriverResource);
        var driverId = driverCommandService.handle(deleteDriverCommand);
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
}
