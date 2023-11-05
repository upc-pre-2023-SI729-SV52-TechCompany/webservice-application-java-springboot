package com.techcompany.webservice.contracts.domain.model.valueobjects;

public record ExpireCard(String expireCard) {
    public ExpireCard {
        if (expireCard == null || expireCard.isBlank()) {
            throw new IllegalArgumentException("Expire card cannot be null or blank");
        } else if (expireCard.length() != 5) {
            throw new IllegalArgumentException("Expire card must be 5 digits");
        } else if (!expireCard.matches("[0-9]+")) {
            throw new IllegalArgumentException("Expire card must be numeric");
        }
    }

    public ExpireCard() {
        this(null);
    }

    public String getExpireCard() {
        return expireCard;
    }
}
