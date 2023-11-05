package com.techcompany.webservice.contracts.domain.model.valueobjects;

public record CardNum(String cardNum) {
    public CardNum {
        if (cardNum == null) {
            throw new IllegalArgumentException("Card number cannot be null");
        } else if (cardNum.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits");
        } else if (!cardNum.matches("[0-9]+")) {
            throw new IllegalArgumentException("Card number must be numeric");
        }
    }

    public CardNum() {
        this(null);
    }

    public String getCardNum() {
        return cardNum;
    }
}
