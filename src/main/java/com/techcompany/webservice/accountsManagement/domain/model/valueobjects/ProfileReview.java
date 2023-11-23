package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record ProfileReview(String profileReview) {
    public ProfileReview(){this(null);}
    public String getProfileReview(){ return profileReview;}
}
