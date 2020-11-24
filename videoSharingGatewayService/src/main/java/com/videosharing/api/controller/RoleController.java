package com.videosharing.api.controller;

import com.videosharing.api.dto.RolePayload;
import com.videosharing.model.Role;

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
    public Role create(@RequestBody RolePayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> result = restTemplate.postForEntity(url, payload, Role.class);
        return result.getBody();
    }

    @GetMapping
    public List<Role> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Role>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Role show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public Role delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}