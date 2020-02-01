package kz.iitu.jd3.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "product_requests";

    @Autowired
    private KafkaTemplate<String, ProductRequest> kafkaTemplate;

    public String productRequestNotify(ProductRequest productRequest) {
        System.out.println(String.format("#### -> Producing product request to notification service -> %s", productRequest));
        this.kafkaTemplate.send(TOPIC, productRequest);
        return "Successfully";
    }
}
