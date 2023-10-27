package com.techcompany.webservice.accountsManagement.interfaces.acl;

import com.techcompany.webservice.accountsManagement.domain.model.commands.CreateAccountCommand;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAccountByEmailQuery;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.EmailAddress;
import com.techcompany.webservice.accountsManagement.domain.services.AccountCommandService;
import com.techcompany.webservice.accountsManagement.domain.services.AccountQueryService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountContextFacade {
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    public AccountContextFacade(
            AccountCommandService accountCommandService,
            AccountQueryService accountQueryService) {
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;

    }

    public Long createAccount(
            String name,
            String email,
            String country,
            Date birthday,
            Long phonenumber,
            String username,
            String password) {
        var createAccountCommand = new CreateAccountCommand(name, email, country, birthday, phonenumber, username, password);
        return accountCommandService.handle(createAccountCommand);
    }

    public Long getAccountByEmail(String email) {
        var getAccountByEmailQuery = new GetAccountByEmailQuery(new EmailAddress(email));
        var account = accountQueryService.handle(getAccountByEmailQuery);
        if (account.isEmpty()) {
            return 0L;
        }

        return account.get().getId();
    }
}
