package com.Payment.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment")
public class Controller {
    @Autowired
    PayRepository payRepository;

    @GetMapping
    public String get(){
        return "Hello, World";
    }

    @GetMapping("/all")
    public List<Payment> allRent(){
        return payRepository.findAll();
    }
    @PostMapping("/add")
    public Payment createRent(@Valid @RequestBody Payment payment) {
       Date date = new Date();
       payment.setDate(date.toString());
        return payRepository.save(payment);
    }
    @GetMapping("/payments/{id}")
    public Payment getById(@PathVariable(value = "id") Long PaymentID)
            throws ResourceNotFoundException {
        Payment payment= payRepository.findById(PaymentID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + PaymentID));
        return payment;
    }
    @GetMapping("/payments/byUserId/{userId}")
    public List<Payment> getByUserId(@PathVariable(value = "userId") String userId)
            throws ResourceNotFoundException {
        return payRepository.getAllByUserId(userId);
    }
    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> update(@PathVariable(value = "id") Long PaymentID,
                                           @Valid @RequestBody Payment paymentDetails) throws ResourceNotFoundException {
        Payment payment = payRepository.findById(PaymentID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + PaymentID));

        payment.setUserId(paymentDetails.getUserId());
        payment.setAmount(paymentDetails.getAmount());
        payment.setCardNumber(paymentDetails.getCardNumber());
        payment.setProductId(paymentDetails.getProductId());

        final Payment updated = payRepository.save(payment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/payments/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long PaymentID)
            throws ResourceNotFoundException {
        Payment payment = payRepository.findById(PaymentID)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id :: " + PaymentID));

        payRepository.delete(payment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
