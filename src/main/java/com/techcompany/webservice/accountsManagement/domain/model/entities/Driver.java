package com.techcompany.webservice.accountsManagement.domain.model.entities;

import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private EmailAddress email;
    @Embedded
    private Password password;
    @Embedded
    private PersonName fullName;
    @Embedded
    private PhoneNumber phone;
    @Embedded
    private Birthdate birthdate;
    @Embedded
    private IdNumber idNumber;
    @Embedded
    private Age age;
    @Embedded
    private Country country;
    @Embedded
    private Photo photo;
    @Embedded
    private Job job;
    @Embedded
    private TimeExperience timeExperience;
    @Embedded
    private License license;
    @Embedded
    private Soat soat;
    @Embedded
    private PropertyDocument propertyDocument;
    @Embedded
    private Certificate certificate;
    @Embedded
    private PhotoVehicle photoVehicle;
    @Embedded
    private Username username;
    @Embedded
    private UserDescription userDescription;
}
