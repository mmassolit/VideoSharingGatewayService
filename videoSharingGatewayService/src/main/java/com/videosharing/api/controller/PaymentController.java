package com.videosharing.api.controller;

import com.videosharing.api.dto.PaymentPayload;
import com.videosharing.model.Payment;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/payment")
@NoArgsConstructor
public class PaymentController {

    private final String url = "http://payments:8086/payment";

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody PaymentPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Payment> result = restTemplate.postForEntity(url, payload, Payment.class);
        return result;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Payment>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    }

    @GetMapping("{id}")
    public ResponseEntity<Payment> show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Payment> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Payment> delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Payment> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    } 
}