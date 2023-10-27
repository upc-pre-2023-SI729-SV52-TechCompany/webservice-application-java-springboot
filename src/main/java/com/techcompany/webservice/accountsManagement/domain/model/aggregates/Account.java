package com.techcompany.webservice.accountsManagement.domain.model.aggregates;

import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Account extends AbstractAggregateRoot<Account> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Embedded
    private PersonName name;
    @Embedded
    private EmailAddress email;
    @Embedded
    private Country country;
    @Embedded
    private Birthdate birthdate;
    @Embedded
    private PhoneNumber phoneNumber;
    @Embedded
    private Username username;
    @Embedded
    private Password password;

    public Account(String name, String email, String country, Date birthdate, Long phoneNumber, String username, String password) {
        this.name = new PersonName(name);
        this.email = new EmailAddress(email);
        this.country = new Country(country);
        this.birthdate = new Birthdate(birthdate);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.username = new Username(username);
        this.password = new Password(password);
    }

    public Account() {
    }

    public void updateName(String name) {
        this.name = new PersonName(name);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public String getName() {
        return this.name.gelFullName();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    public String getPassword() {
        return this.password.getPassword();
    }

    public String getCountry() {
        return this.country.getCountry();
    }

    public Date getBirthdate() {
        return this.birthdate.getBirthdate();
    }

    public Long getPhoneNumber() {
        return this.phoneNumber.getPhoneNumber();
    }

    public String getUsername() {
        return this.username.getUsername();
    }
}
