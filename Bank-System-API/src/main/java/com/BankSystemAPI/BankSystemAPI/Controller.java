package com.BankSystemAPI.BankSystemAPI;

import com.BankSystemAPI.BankSystemAPI.Services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    InfoService infoService;

    @GetMapping
    public String gerStr(){
        return "It's Catalog page";
    }

    @GetMapping("/all")
    public List<Replenishment> getAll(){
        return infoService.getAll();
    }

    @GetMapping("rep/{id}")
    public Replenishment getRep(@PathVariable Long id){
        return infoService.getRep(id);
    }
    @GetMapping("rep/byUserId/{userID}")
    public Replenishment getId(@PathVariable String userID){
        return infoService.getId(userID);
    }
//    @GetMapping("payment/byUserId/{userID}")
//    public Payment getPaymnent(@PathVariable String userID){
//        return infoService.getPayment(userID);
//    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping
//    public String getStr(){
//        Replenishment result = restTemplate.postForObject("http://localhost:8082/rep/add",
//                new Replenishment("1", "34$", "789456"), Replenishment.class);
//        Payment pay= restTemplate.postForObject("http://localhost:8084/payment/add",
//                new Payment("1","1","21$","12423","52"), Payment.class);
//        SendingMoney sm= restTemplate.postForObject("http://localhost:8084/sending/add",
//                new SendingMoney("1","1","53$","5698","5223"),SendingMoney.class);
//
//        return "It's Catalog page";
//
//    }
//    @GetMapping("/all")
//    public List<Replenishment> getAllGames() {
//        ResponseEntity<List<Replenishment>> rateResponse =
//                restTemplate.exchange("http://localhost:8082/rep/all",
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Replenishment>>() {
//                        });
//        List<Replenishment> rates = rateResponse.getBody();
//        return rates;
//    }
//
//    @GetMapping("rep/{id}")
//    public Replenishment getGames(@PathVariable Long id) {
//        Replenishment  game = restTemplate.getForObject(
//                "http://localhost:8082/rep/reps/"+id,
//                Replenishment.class);
//        return game;
//    }
//    @PostMapping("/rep/reps")
//    public Replenishment createNote(@Valid @RequestBody Replenishment game) {
//        return restTemplate.postForObject("http://localhost:8082/rep/add",
//                game, Replenishment.class);
//    }
//
//    @DeleteMapping("/rep/{id}")
//    public Boolean delete(@PathVariable String id) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("id", id);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.delete("http://localhost:8082/reps/"+id, params);
//        return true;
//    }
//
//    @GetMapping("/{id}")
//    public List<Catalog> getAllDates(
//            @PathVariable String id) {
//        Replenishment user= restTemplate.getForObject(
//                "http://localhost:8082/rep/" + id,
//                Replenishment.class);
//
//        List<Catalog> CatalogList = new ArrayList<>();
//
//
//        Payment payment = restTemplate.getForObject(
//                "http://localhost:8084/payment/" + user.getId(),
//                Payment.class);
//        SendingMoney money= restTemplate.getForObject(
//                "http://localhost:8083/sending/" + user.getId(),
//                SendingMoney.class);
//
//        CatalogList.add(new Catalog(user.getId(),user.getUserID(),payment.getAmount(),money.getCardNumber(),money.getReceiverCardNumber()));
//        //   }
//
//        return CatalogList;
//    }

}
