package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.Account;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAccountByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAccountByIdQuery;

import java.util.Optional;

public interface AccountQueryService {
    Optional<Account> handle(GetAccountByIdQuery query);
    Optional<Account> handle(GetAccountByEmailQuery query);
}
