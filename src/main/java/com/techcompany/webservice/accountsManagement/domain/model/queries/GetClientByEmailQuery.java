package com.techcompany.webservice.accountsManagement.domain.model.queries;

import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.EmailAddress;

public record GetClientByEmailQuery(EmailAddress email) {
}
