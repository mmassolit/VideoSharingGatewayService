package com.videosharing.api.controller;

import com.videosharing.api.dto.AdPayload;
import com.videosharing.model.Ad;

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
    public ResponseEntity<Ad> create(@RequestBody AdPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ad> result = restTemplate.postForEntity(url, payload, Ad.class);
        return result;
    }

    @GetMapping
    public ResponseEntity<List<Ad>> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Ad>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    }

    @GetMapping("{id}")
    public ResponseEntity<Ad> show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ad> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Ad> delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ad> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    } 
}