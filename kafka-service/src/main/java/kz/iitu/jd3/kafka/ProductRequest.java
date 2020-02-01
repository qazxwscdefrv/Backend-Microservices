package kz.iitu.jd3.kafka;

import java.util.List;

public class ProductRequest {

    private String userId;
    private List<Product> product;

    public ProductRequest(String userId, List<Product> product) {
        this.userId = userId;
        this.product = product;
    }

    public ProductRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "userId='" + userId + '\'' +
                ", product=" + product +
                '}';
    }
}
