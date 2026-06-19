package com.acme.paymentservice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@Validated
public class PaymentController {

    @PostMapping
    public ResponseEntity<Map<String, String>> charge(@RequestBody PaymentRequest request) {
        String transactionId = UUID.randomUUID().toString();
        return ResponseEntity.ok(Map.of(
            "transactionId", transactionId,
            "status", "ACCEPTED",
            "amount", String.valueOf(request.getAmount()),
            "currency", request.getCurrency()
        ));
    }
}
