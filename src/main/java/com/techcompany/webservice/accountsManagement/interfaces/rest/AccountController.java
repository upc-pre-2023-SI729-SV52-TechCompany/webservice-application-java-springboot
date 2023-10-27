package com.techcompany.webservice.accountsManagement.interfaces.rest;

import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAccountByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.AccountCommandService;
import com.techcompany.webservice.accountsManagement.domain.services.AccountQueryService;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.AccountResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateAccountResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.AccountResourceFromEntityAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.CreateAccountCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    public AccountController(AccountCommandService accountCommandService, AccountQueryService accountQueryService) {
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }

    @PostMapping("/register")
    public ResponseEntity<AccountResource> createAccount(@RequestBody CreateAccountResource resource){
        var createAccountCommand = CreateAccountCommandFromResourceAssembler.toCommandFromResource(resource);
        var profileId = accountCommandService.handle(createAccountCommand);
        if (profileId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getAccountByIdQuery = new GetAccountByIdQuery(profileId);
        var account = accountQueryService.handle(getAccountByIdQuery);
        if (account.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var accountResource = AccountResourceFromEntityAssembler.toResourceFromEntity(account.get());
        return new ResponseEntity<>(accountResource, HttpStatus.CREATED);
    }

    /*
     @Annotation
     - The @GetMapping annotation is used to map HTTP GET requests onto specific handler methods.
     @EndPoint
        - http://localhost:8080/api/v1/login
     */

}
