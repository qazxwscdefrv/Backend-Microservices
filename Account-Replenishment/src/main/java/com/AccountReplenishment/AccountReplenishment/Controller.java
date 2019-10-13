package com.AccountReplenishment.AccountReplenishment;

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
@RequestMapping("/rep")
public class Controller {
    @Autowired
    Repository repository;
    @GetMapping
    public String get(){
        return "Hello, World";
    }

    @GetMapping("/all")
    public List<Replenishment> allRent(){
        return repository.findAll();
    }
    @PostMapping("/add")
    public Replenishment createRent(@Valid @RequestBody Replenishment replenishment) {
        return repository.save(replenishment);
    }
    @GetMapping("/reps/{id}")
    public Replenishment getById(@PathVariable(value = "id") Long replenishmentID)
            throws ResourceNotFoundException {
        Replenishment replenishment= repository.findById(replenishmentID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + replenishmentID));
        return replenishment;
    }
    @PutMapping("/reps/{id}")
    public ResponseEntity<Replenishment> update(@PathVariable(value = "id") Long replenishmentID,
                                               @Valid @RequestBody Replenishment replenishmentDetails) throws ResourceNotFoundException {
        Replenishment replenishment = repository.findById(replenishmentID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + replenishmentID));

        replenishment.setUserID(replenishmentDetails.getUserID());
        replenishment.setAmount(replenishmentDetails.getAmount());
        replenishment.setCardNumber(replenishmentDetails.getCardNumber());

        final Replenishment updated = repository.save(replenishment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/reps/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long replenishmentID)
            throws ResourceNotFoundException {
        Replenishment replenishment = repository.findById(replenishmentID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + replenishmentID));

        repository.delete(replenishment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
