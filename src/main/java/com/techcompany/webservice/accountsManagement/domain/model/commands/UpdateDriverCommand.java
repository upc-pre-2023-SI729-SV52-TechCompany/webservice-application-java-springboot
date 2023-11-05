package com.techcompany.webservice.accountsManagement.domain.model.commands;

import java.util.Date;

public record UpdateDriverCommand(
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
        String photoVehicle2,
        String username,
        String userDescription
) {
}
