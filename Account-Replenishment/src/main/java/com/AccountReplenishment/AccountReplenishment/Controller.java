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

@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/reps/byUserId/{userId}")
    public Replenishment getByUserId(@PathVariable(value = "userId") String userId)
            throws ResourceNotFoundException {
        Replenishment replenishment= repository.getReplenishmentByUserID(userId);
        return replenishment;
    }
    @GetMapping("/reps/byCard/{cardNumber}")
    public Replenishment getBycardNumber(@PathVariable(value = "cardNumber") String cardNumber)
            throws ResourceNotFoundException {
        Replenishment replenishment= repository.getReplenishmentByCardNumber(cardNumber);
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
    @PutMapping("/byUser/{userId}")
    public ResponseEntity<Replenishment> updateRep(@PathVariable(value = "userId") String userId,
                                                   @RequestParam("amount") String amount,
                                                   @RequestParam("id") Long id,
                                                   @Valid @RequestBody Replenishment replenishmentDetails) throws ResourceNotFoundException {
        Replenishment replenishment = repository.getReplenishmentByUserID(userId);
        int total = 0;
        total = Integer.parseInt(replenishment.amount) + Integer.parseInt(amount);

        replenishment.setAmount(total+"");

        Replenishment updated = repository.save(replenishment);

        Replenishment replenishment1 = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + id));
        int total1 = 0;
        total1 = Integer.parseInt(replenishment1.amount) - Integer.parseInt(amount);

        replenishment1.setAmount(total1+"");

         Replenishment updated1 = repository.save(replenishment1);
         ResponseEntity.ok(updated1);
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
