package com.videosharing.api.controller;

import com.videosharing.api.dto.PaymentPayload;

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
    public PaymentPayload create(@RequestBody PaymentPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PaymentPayload> result = restTemplate.postForEntity(url, payload, PaymentPayload.class);
        return result.getBody();
    }

    @GetMapping
    public List<PaymentPayload> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PaymentPayload>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public PaymentPayload show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PaymentPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public PaymentPayload delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PaymentPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}