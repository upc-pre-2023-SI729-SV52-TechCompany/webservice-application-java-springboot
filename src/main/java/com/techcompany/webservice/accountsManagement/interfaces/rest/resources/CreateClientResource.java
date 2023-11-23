package com.techcompany.webservice.accountsManagement.interfaces.rest.resources;

import java.util.Date;

public record CreateClientResource(
        String email,
        String password,
        String fullName,
        String phone,
        Date birthdate,
        Long idNumber,
        Integer age,
        String country,
        String photo,
        String username,
        String userDescription,
        String profileReview
) {
}
