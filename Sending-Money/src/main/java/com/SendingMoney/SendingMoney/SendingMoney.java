package com.SendingMoney.SendingMoney;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "SendingMoney")
public class SendingMoney {
    public SendingMoney() {
    }

    public SendingMoney(String userId, String amount, String cardNumber, String receiverCardNumber) {
        UserId = userId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        ReceiverCardNumber = receiverCardNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String UserId;
    public String amount;
    public String cardNumber;
    public String ReceiverCardNumber;

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setReceiverCardNumber(String receiverCardNumber) {
        ReceiverCardNumber = receiverCardNumber;
    }
}
