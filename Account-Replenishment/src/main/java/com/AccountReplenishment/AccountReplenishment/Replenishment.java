package com.AccountReplenishment.AccountReplenishment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Account_Replenishment")
public class Replenishment {
    public Replenishment() {
    }

    public Replenishment(String userID, String amount, String cardNumber) {
        this.userID = userID;
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String userID;
    public String amount;
    public String cardNumber;

    public Long getId() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public String getAmount() {
        return amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
