package com.techcompany.webservice.contracts.domain.model.valueobjects;

public record CvvCard(String cvvCard) {
    public CvvCard {
        if (cvvCard == null) {
            throw new IllegalArgumentException("CVV card cannot be null");
        } else if (cvvCard.length() != 3) {
            throw new IllegalArgumentException("CVV card must be 3 digits");
        } else if (!cvvCard.matches("[0-9]+")) {
            throw new IllegalArgumentException("CVV card must be numeric");
        }
    }

    public CvvCard() {
        this(null);
    }

    public String getCvvCard() {
        return cvvCard;
    }
}
