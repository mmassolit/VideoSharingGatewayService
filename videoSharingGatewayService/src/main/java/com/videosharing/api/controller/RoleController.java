package com.videosharing.api.controller;

import com.videosharing.api.dto.RolePayload;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/role")
@NoArgsConstructor
public class RoleController {

    private final String url = "http://roles:8081/role";

    @PostMapping
    public RolePayload create(@RequestBody RolePayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RolePayload> result = restTemplate.postForEntity(url, payload, RolePayload.class);
        return result.getBody();
    }

    @GetMapping
    public List<RolePayload> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<RolePayload>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public RolePayload show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RolePayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public RolePayload delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RolePayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}