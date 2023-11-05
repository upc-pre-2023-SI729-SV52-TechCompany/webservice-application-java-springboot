package com.techcompany.webservice.accountsManagement.interfaces.rest.resources;

import java.util.Date;

public record DriverResource(
        String email,
        String password,
        String fullName,
        String phone,
        Date birthdate,
        Integer idNumber,
        Long age,
        String country,
        String photo,
        String job,
        String timeExperience,
        String license,
        String soat,
        String propertyDocument,
        String certificate,
        String photoVehicle,
        String username,
        String userDescription
) {
}
