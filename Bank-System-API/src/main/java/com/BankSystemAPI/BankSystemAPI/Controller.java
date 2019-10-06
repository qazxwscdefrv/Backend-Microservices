package com.BankSystemAPI.BankSystemAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/{id}")
    public List<Catalog> getAllDates(
            @PathVariable String id) {
        Replenishment user= restTemplate.getForObject(
                "http://localhost:8082/rep/" + id,
                Replenishment.class);

        List<Catalog> CatalogList = new ArrayList<>();


        Payment payment = restTemplate.getForObject(
                "http://localhost:8084/payment/" + user.getId(),
                Payment.class);
        SendingMoney money= restTemplate.getForObject(
                "http://localhost:8083/sending/" + user.getId(),
                SendingMoney.class);

        CatalogList.add(new Catalog(user.getId(),user.getUserID(),payment.getAmount(),money.getCardNumber(),money.getReceiverCardNumber()));
        //   }

        return CatalogList;
    }

}
