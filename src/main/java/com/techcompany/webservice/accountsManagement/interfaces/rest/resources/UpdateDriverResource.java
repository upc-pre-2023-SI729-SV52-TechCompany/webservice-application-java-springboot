package com.techcompany.webservice.accountsManagement.interfaces.rest.resources;

import java.util.Date;

public record UpdateDriverResource(
        Long driverId,
        String email,
        String password,
        String fullName,
        String phone,
        Date birthdate,
        Long idNumber,
        Integer age,
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
        String userDescription,
        String profileReview
) {
}
