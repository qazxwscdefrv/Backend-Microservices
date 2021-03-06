package com.BankSystemAPI.BankSystemAPI;

public class Payment {
    public Payment() {
    }

    public Payment(String id, String userId, String amount, String cardNumber, String productId) {
        this.id = id;
        UserId = userId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        ProductId = productId;
    }

    public String id;
    public String UserId;
    public String amount;
    public String cardNumber;
    public String ProductId;

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

    public String getProductId() {
        return ProductId;
    }
}
