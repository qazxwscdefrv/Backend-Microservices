package kz.iitu.jd3.kafka;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Product {
    public Product() {
    }

    public Product(String userId, String amount, String cardNumber, String productId, String date) {
        this.userId = userId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        ProductId = productId;
        this.date = date;
    }

    public Long id;
    public String userId;
    public String amount;
    public String cardNumber;
    public String ProductId;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", amount='" + amount + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", ProductId='" + ProductId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
