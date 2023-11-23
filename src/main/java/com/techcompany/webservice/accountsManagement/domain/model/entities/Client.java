package com.techcompany.webservice.accountsManagement.domain.model.entities;

import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
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
    private Username username;
    @Embedded
    private UserDescription userDescription;
    @Embedded
    private ProfileReview profileReview;

    public Client(String email, String password, String fullName, String phone, Date birthdate, Long idNumber, Integer age, String country, String photo, String username, String userDescription, String profileReview) {
        this.email = new EmailAddress(email);
        this.password = new Password(password);
        this.fullName = new PersonName(fullName);
        this.phone = new PhoneNumber(phone);
        this.birthdate = new Birthdate(birthdate);
        this.idNumber = new IdNumber(idNumber);
        this.age = new Age(age);
        this.country = new Country(country);
        this.photo = new Photo(photo);
        this.username = new Username(username);
        this.userDescription = new UserDescription(userDescription);
        this.profileReview = new ProfileReview(profileReview);
    }

    public void updateClientInfo(String email, String password, String fullName, String phone, Date birthdate, Long idNumber, Integer age, String country, String photo, String username, String userDescription, String profileReview) {
        this.email = new EmailAddress(email);
        this.password = new Password(password);
        this.fullName = new PersonName(fullName);
        this.phone = new PhoneNumber(phone);
        this.birthdate = new Birthdate(birthdate);
        this.idNumber = new IdNumber(idNumber);
        this.age = new Age(age);
        this.country = new Country(country);
        this.photo = new Photo(photo);
        this.username = new Username(username);
        this.userDescription = new UserDescription(userDescription);
        this.profileReview = new ProfileReview(profileReview);
    }

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

    public String getProfileReview(){
        return profileReview.getProfileReview();
    }

    public void setProfileReview(String profileReview){
        this.profileReview = new ProfileReview(profileReview);
    }
}
