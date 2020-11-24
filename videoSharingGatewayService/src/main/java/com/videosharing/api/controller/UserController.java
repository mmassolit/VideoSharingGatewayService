package com.videosharing.api.controller;

import com.videosharing.api.dto.UserPayload;
import com.videosharing.model.User;

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
    public User create(@RequestBody UserPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> result = restTemplate.postForEntity(url, payload, User.class);
        return result.getBody();
    }

    @GetMapping
    public List<User> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public User show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public User delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}