package com.Payment.Payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class Controller {
    @GetMapping
    public String get(){
        return "Hello, World";
    }
    @GetMapping("/{id}")
    public Payment getInfoAboutPayment(
            @PathVariable("id") String id){
        List<Payment> list =  Arrays.asList(
                new Payment("1", "1","15$","1632-1523","265"),
                new Payment("2", "2","15$","1632-1523","565"));
        for (Payment repList : list) {
            if (repList.id.equals(id)) {
                return repList;
            }
        }
        return null;
    }
}
