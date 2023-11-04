package com.techcompany.webservice.accountsManagement.interfaces.rest.resources;

import java.util.Date;

public record UpdateClientResource(
        String email,
        String password,
        String fullName,
        Long phone,
        Date birthdate,
        Long idNumber,
        Integer age,
        String country,
        String photo,
        String username,
        String userDescription
) {
}
