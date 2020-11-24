package com.videosharing.api.controller;

import com.videosharing.api.dto.BalanceTransactionPayload;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/balance-transaction")
@NoArgsConstructor
public class BalanceTransactionController {

    private final String url = "http://balance-transactions:8085/balance-transaction";

    @PostMapping
    public BalanceTransactionPayload create(@RequestBody BalanceTransactionPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BalanceTransactionPayload> result = restTemplate.postForEntity(url, payload, BalanceTransactionPayload.class);
        return result.getBody();
    }

    @GetMapping
    public List<BalanceTransactionPayload> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<BalanceTransactionPayload>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public BalanceTransactionPayload show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BalanceTransactionPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public BalanceTransactionPayload delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BalanceTransactionPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}