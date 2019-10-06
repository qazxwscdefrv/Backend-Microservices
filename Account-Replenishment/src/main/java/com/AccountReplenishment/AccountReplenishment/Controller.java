package com.AccountReplenishment.AccountReplenishment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rep")
public class Controller {
    @GetMapping
    public String get(){
        return "Hello, World";
    }
    @GetMapping("/{id}")
    public Replenishment getInfoAboutRep(
            @PathVariable ("id") String id){
        List<Replenishment> list =  Arrays.asList(
                new Replenishment("1", "1","15$","1632-1523-1536-1235"),
                new Replenishment("2", "2","15$","1632-1523-1536-1235"));
        for (Replenishment repList : list) {
            if (repList.id.equals(id)) {
                return repList;
            }
        }
        return null;
    }


}
