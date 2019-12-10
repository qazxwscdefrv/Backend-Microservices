package com.BankSystemAPI.BankSystemAPI;

public class Catalog {
    public Catalog() {
    }

//    public Catalog(Long id, String userId, String amount, String cardNumber, String receiverCardNumber) {
//        this.id = id;
//        UserId = userId;
//        this.amount = amount;
//        this.cardNumber = cardNumber;
//        ReceiverCardNumber = receiverCardNumber;
//    }

    public Catalog(Long id, String userId, String amount, String cardNumber, String receiverCardNumber) {
        this.id = id;
        UserId = userId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        ReceiverCardNumber = receiverCardNumber;
    }

    public Long id;
    public String UserId;
    public String amount;
    public String cardNumber;
    public String ReceiverCardNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getReceiverCardNumber() {
        return ReceiverCardNumber;
    }

    public void setReceiverCardNumber(String receiverCardNumber) {
        ReceiverCardNumber = receiverCardNumber;
    }
}
