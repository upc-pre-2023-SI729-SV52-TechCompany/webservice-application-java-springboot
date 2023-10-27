package com.techcompany.webservice.accountsManagement.application.internal.commandservices;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.Account;
import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateAccountCommand;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.EmailAddress;
import com.techcompany.webservice.accountsManagement.domain.services.AccountCommandService;

import com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {
    private final AccountRepository accountRepository;

    public AccountCommandServiceImpl(AccountRepository profileRepository) {
        this.accountRepository = profileRepository;
    }

    @Override
    public Long handle(CreateAccountCommand command) {
        var email = new EmailAddress((command.email()));
        accountRepository.findByEmail(email).map(account -> {
            throw new IllegalStateException("Email already taken");
        });
        var account = new Account(command.name(), command.email(), command.country(), command.birthday(), command.phonenumber(), command.username(), command.password());
        accountRepository.save(account);
        return account.getId();
    }
}
