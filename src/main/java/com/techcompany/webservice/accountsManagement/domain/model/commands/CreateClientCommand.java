package com.techcompany.webservice.accountsManagement.domain.model.commands;

import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;

import java.util.Date;

public record CreateClientCommand(
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
