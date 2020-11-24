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
    public Payment create(@RequestBody PaymentPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Payment> result = restTemplate.postForEntity(url, payload, Payment.class);
        return result.getBody();
    }

    @GetMapping
    public List<Payment> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Payment>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Payment show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Payment> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public Payment delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Payment> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}