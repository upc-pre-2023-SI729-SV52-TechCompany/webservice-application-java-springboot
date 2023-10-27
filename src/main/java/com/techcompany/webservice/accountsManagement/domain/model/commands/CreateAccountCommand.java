package com.techcompany.webservice.accountsManagement.domain.model.commands;

import java.util.Date;

public record CreateAccountCommand(String name, String email, String country, Date birthday, Long phonenumber, String username, String password) {
}
