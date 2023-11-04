package com.techcompany.webservice.accountsManagement.interfaces.rest.resources;

import java.util.Date;

public record CreateDriverResource(
        String email,
        String password,
        String fullName,
        Long phone,
        Date birthdate,
        Integer age,
        Long idNumber,
        String country,
        String photo,
        String job,
        String timeExperience,
        String license,
        String soat,
        String propertyDocument,
        String certificate,
        String photoVehicle,
        String photoVehicle2,
        String username,
        String userDescription
) {
}
