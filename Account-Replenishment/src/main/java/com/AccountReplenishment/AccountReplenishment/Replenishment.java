package com.AccountReplenishment.AccountReplenishment;

public class Replenishment {
    public Replenishment() {
    }

    public Replenishment(String id, String userID, String amount, String cardNumber) {
        this.id = id;
        this.userID = userID;
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    public String id;
    public String userID;
    public String amount;
    public String cardNumber;

    public String getId() {
        return id;
    }
}