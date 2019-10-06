package com.BankSystemAPI.BankSystemAPI;

public class Catalog {
    public Catalog() {
    }

    public Catalog(String id, String userId, String amount, String cardNumber, String receiverCardNumber) {
        this.id = id;
        UserId = userId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        ReceiverCardNumber = receiverCardNumber;
    }

    public String id;
    public String UserId;
    public String amount;
    public String cardNumber;
    public String ReceiverCardNumber;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return UserId;
    }

    public String getAmount() {
        return amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getReceiverCardNumber() {
        return ReceiverCardNumber;
    }
}
