package com.BankSystemAPI.BankSystemAPI.Services;


import com.BankSystemAPI.BankSystemAPI.Payment;
import com.BankSystemAPI.BankSystemAPI.Replenishment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service

public class InfoService {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @HystrixCommand(fallbackMethod = "getAll_Fallback")
    public List<Replenishment> getAll() {
        ResponseEntity<List<Replenishment>> rateResponse =
                restTemplate.exchange("http://localhost:8082/rep/all",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Replenishment>>() {
                        });
        List<Replenishment> rates = rateResponse.getBody();
        return rates;
    }
    @HystrixCommand(fallbackMethod = "get_Fallback")
    public Replenishment getRep(@PathVariable Long id) {
        Replenishment  game = restTemplate.getForObject(
                "http://localhost:8082/rep/reps/"+id,
                Replenishment.class);
        return game;
    }

    @HystrixCommand(fallbackMethod = "getId_Fallback")
    public Replenishment getId(@PathVariable String userID) {
        Replenishment  game = restTemplate.getForObject(
                "http://localhost:8082/rep/reps/byUserId/"+userID,
                Replenishment.class);
        return game;
    }
//    @HystrixCommand(fallbackMethod = "getPayment_Fallback")
//    public Payment getPayment(@PathVariable String UserId) {
//        Payment  game = restTemplate.getForObject(
//                "http://localhost:8084/payment/payments/"+UserId,
//                Payment.class);
//        return game;
//    }

    @SuppressWarnings("unused")
    private List<Replenishment> getAll_Fallback() {
        System.out.println("Service is down!!! fallback route enabled...");
        List<Replenishment> list =  Arrays.asList(
                new Replenishment("No Response ","NULL","NULL"));
        return list;
    }

    @SuppressWarnings("unused")
    private Replenishment get_Fallback(Long id) {

        System.out.println("Service is down!!! fallback route enabled...");
        Replenishment list=new Replenishment("No Response ","null","null");
        return list;
    }
    @SuppressWarnings("unused")
    private Replenishment getId_Fallback(String userID) {

        System.out.println("Service is down!!! fallback route enabled...");
        Replenishment list=new Replenishment("No Response ","null","null");
        return list;}

//    @SuppressWarnings("unused")
//    private Payment getPayment_Fallback(String userID) {
//
//        System.out.println("Service is down!!! fallback route enabled...");
//        Payment list=new Payment("null","No Response ","null","null","null");
//        return list;
//    }

}

