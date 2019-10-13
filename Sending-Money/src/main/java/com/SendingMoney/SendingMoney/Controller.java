package com.SendingMoney.SendingMoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sending")
public class Controller {
    @Autowired
    Repository repository;
    @GetMapping
    public String get(){
        return "Hello, World";
    }

    @GetMapping("/all")
    public List<SendingMoney> allRent(){
        return repository.findAll();
    }
    @PostMapping("/add")
    public SendingMoney createRent(@Valid @RequestBody SendingMoney sendingMoney) {
        return repository.save(sendingMoney);
    }
    @GetMapping("/sendings/{id}")
    public SendingMoney getById(@PathVariable(value = "id") Long SendingID)
            throws ResourceNotFoundException {
        SendingMoney sendingMoney= repository.findById(SendingID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + SendingID));
        return sendingMoney;
    }
    @PutMapping("/sendings/{id}")
    public ResponseEntity<SendingMoney> update(@PathVariable(value = "id") Long SendingID,
                                          @Valid @RequestBody SendingMoney sendingDetails) throws ResourceNotFoundException {
        SendingMoney sendingMoney = repository.findById(SendingID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + SendingID));

        sendingMoney.setUserId(sendingDetails.getUserId());
        sendingMoney.setAmount(sendingDetails.getAmount());
        sendingMoney.setCardNumber(sendingDetails.getCardNumber());
        sendingMoney.setReceiverCardNumber(sendingDetails.getReceiverCardNumber());

        final SendingMoney updated = repository.save(sendingMoney);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/sendings/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long SendingID)
            throws ResourceNotFoundException {
        SendingMoney sendingMoney = repository.findById(SendingID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + SendingID));

        repository.delete(sendingMoney);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
