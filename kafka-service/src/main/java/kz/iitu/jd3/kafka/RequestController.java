package kz.iitu.jd3.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    private final Producer producer;


    @Autowired
    public RequestController(Producer producer) {
        this.producer = producer;
    }

    // TODO Ideally there should POST request
    @GetMapping("/{user}")
    public List<Product> sendMessageToKafkaTopic2(@PathVariable String user) {
        ResponseEntity<List<Product>> rateResponse =
                restTemplate.exchange("http://localhost:8084/payment/payments/byUserId/" + user,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
                        });
        List<Product> rates = rateResponse.getBody();

        ProductRequest productRequest = new ProductRequest(user, rates);
        this.producer.productRequestNotify(productRequest);
        return rates;
    }
//    @GetMapping("send")
//    public String sendMessageToKafkaTopic() {
//
//        BookRequest bookRequest = new BookRequest("2", new Book("2","Replenishment","Sati","Replenishment bank account"));
//        this.producer.bookRequestNotify(bookRequest);
//        return "Your request sent successful!";
//    }
}
