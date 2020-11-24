package com.videosharing.api.controller;

import com.videosharing.api.dto.UserPayload;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class UserController {

    private final String url = "http://users:8082/user";

    @PostMapping
    public UserPayload create(@RequestBody UserPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserPayload> result = restTemplate.postForEntity(url, payload, UserPayload.class);
        return result.getBody();
    }

    @GetMapping
    public List<UserPayload> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserPayload>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public UserPayload show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public UserPayload delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}