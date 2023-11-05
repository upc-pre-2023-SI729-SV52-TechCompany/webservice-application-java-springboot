package com.techcompany.webservice.accountsManagement.domain.model.commands;

import java.util.Date;

public record CreateDriverCommand(
        String email,
        String password,
        String fullName,
        String phone,
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
        String username,
        String userDescription
) {
}
