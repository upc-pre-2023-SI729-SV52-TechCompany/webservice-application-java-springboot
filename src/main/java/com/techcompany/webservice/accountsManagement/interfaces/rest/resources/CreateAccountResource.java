package com.techcompany.webservice.accountsManagement.interfaces.rest.resources;

import java.util.Date;

public record CreateAccountResource(String name, String email, String country, Date birthday, Long phonenumber, String username, String password) {
}
