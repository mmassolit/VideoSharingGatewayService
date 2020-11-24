package com.videosharing.api.controller;

import com.videosharing.api.dto.AdPayload;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/ad")
@NoArgsConstructor
public class AdController {

    private final String url = "http://ads:8083/ad";

    @PostMapping
    public AdPayload create(@RequestBody AdPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AdPayload> result = restTemplate.postForEntity(url, payload, AdPayload.class);
        return result.getBody();
    }

    @GetMapping
    public List<AdPayload> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<AdPayload>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public AdPayload show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AdPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public AdPayload delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AdPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}