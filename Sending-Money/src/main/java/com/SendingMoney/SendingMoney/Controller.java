package com.SendingMoney.SendingMoney;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sending")
public class Controller {

    @GetMapping
    public String get(){
        return "Hello, World";
    }
    @GetMapping("/{id}")
    public SendingMoney getInfoAboutSending(
            @PathVariable("id") String id){
        List<SendingMoney> list =  Arrays.asList(
                new SendingMoney("1", "1","15$","1632-1523","2654-6545"),
                new SendingMoney("2", "2","15$","1632-1523","5656-5656"));
        for (SendingMoney repList : list) {
            if (repList.id.equals(id)) {
                return repList;
            }
        }
        return null;
    }
}
