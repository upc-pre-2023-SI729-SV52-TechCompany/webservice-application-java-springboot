package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.Account;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.AccountResource;

public class AccountResourceFromEntityAssembler {
    public static AccountResource toResourceFromEntity(Account entity){
        return new AccountResource(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCountry(),
                entity.getBirthdate(),
                entity.getPhoneNumber(),
                entity.getUsername(),
                entity.getPassword()
        );
    }
}
