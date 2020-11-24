package com.videosharing.api.controller;

import com.videosharing.api.dto.PlaybackPayload;
import com.videosharing.model.Playback;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/playback")
@NoArgsConstructor
public class PlaybackController {

    private final String url = "http://playbacks:8087/playback";

    @PostMapping
    public Playback create(@RequestBody PlaybackPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Playback> result = restTemplate.postForEntity(url, payload, Playback.class);
        return result.getBody();
    }

    @GetMapping
    public List<Playback> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Playback>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Playback show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Playback> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public Playback delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Playback> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}