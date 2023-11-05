package com.techcompany.webservice.accountsManagement.domain.model.entities;

import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @Getter
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

    // Constructor set attributes of original types
    public Driver(String email, String password, String personName, String phone, Date birthdate, Long idNumber, Integer age, String country, String photo, String job, String timeExperience, String license, String soat, String propertyDocument, String certificate, String photoVehicle, String username, String userDescription) {
        this.email = new EmailAddress(email);
        this.password = new Password(password);
        this.fullName = new PersonName(personName);
        this.phone = new PhoneNumber(phone);
        this.birthdate = new Birthdate(birthdate);
        this.idNumber = new IdNumber(idNumber);
        this.age = new Age(age);
        this.country = new Country(country);
        this.photo = new Photo(photo);
        this.job = new Job(job);
        this.timeExperience = new TimeExperience(timeExperience);
        this.license = new License(license);
        this.soat = new Soat(soat);
        this.propertyDocument = new PropertyDocument(propertyDocument);
        this.certificate = new Certificate(certificate);
        this.photoVehicle = new PhotoVehicle(photoVehicle);
        this.username = new Username(username);
        this.userDescription = new UserDescription(userDescription);

    }

    // Getters and setters
    public String getEmail() {
        return email.getEmail();
    }

    public void setEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public String getPassword() {
        return password.getPassword();
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    public String getFullName() {
        return fullName.getFullName();
    }

    public void setFullName(String fullName) {
        this.fullName = new PersonName(fullName);
    }

    public String getPhone() {
        return phone.getPhoneNumber();
    }

    public void setPhone(String phone) {
        this.phone = new PhoneNumber(phone);
    }

    public Date getBirthdate() {
        return birthdate.getBirthdate();
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = new Birthdate(birthdate);
    }

    public Long getIdNumber() {
        return idNumber.getIdNumber();
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = new IdNumber(idNumber);
    }

    public Integer getAge() {
        return age.getAge();
    }

    public void setAge(Integer age) {
        this.age = new Age(age);
    }

    public String getCountry() {
        return country.getCountry();
    }

    public void setCountry(String country) {
        this.country = new Country(country);
    }

    public String getPhoto() {
        return photo.getPhoto();
    }

    public void setPhoto(String photo) {
        this.photo = new Photo(photo);
    }

    public String getJob() {
        return job.getJob();
    }

    public void setJob(String job) {
        this.job = new Job(job);
    }

    public String getTimeExperience() {
        return timeExperience.getTimeExperience();
    }

    public void setTimeExperience(String timeExperience) {
        this.timeExperience = new TimeExperience(timeExperience);
    }

    public String getLicense() {
        return license.getLicense();
    }

    public void setLicense(String license) {
        this.license = new License(license);
    }

    public String getSoat() {
        return soat.getSoat();
    }

    public void setSoat(String soat) {
        this.soat = new Soat(soat);
    }

    public String getPropertyDocument() {
        return propertyDocument.getPropertyDocument();
    }

    public void setPropertyDocument(String propertyDocument) {
        this.propertyDocument = new PropertyDocument(propertyDocument);
    }

    public String getCertificate() {
        return certificate.getCertificate();
    }

    public void setCertificate(String certificate) {
        this.certificate = new Certificate(certificate);
    }

    public String getPhotoVehicle() {
        return photoVehicle.getPhotoVehicle();
    }

    public void setPhotoVehicle(String photoVehicle) {
        this.photoVehicle = new PhotoVehicle(photoVehicle);
    }

    public String getUsername() {
        return username.getUsername();
    }

    public void setUsername(String username) {
        this.username = new Username(username);
    }

    public String getUserDescription() {
        return userDescription.getUserDescription();
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = new UserDescription(userDescription);
    }
}
