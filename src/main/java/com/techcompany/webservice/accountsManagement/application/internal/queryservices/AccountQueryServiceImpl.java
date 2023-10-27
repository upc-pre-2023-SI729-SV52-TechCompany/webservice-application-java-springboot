package com.techcompany.webservice.accountsManagement.application.internal.queryservices;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.Account;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAccountByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAccountByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.AccountQueryService;
import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {
    private final AccountRepository accountRepository;

    public AccountQueryServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> handle(GetAccountByEmailQuery query){
        return accountRepository.findByEmail(query.email());
    }

    @Override
    public Optional<Account> handle(GetAccountByIdQuery query){

        return accountRepository.findById(query.accountid());
    }
}
