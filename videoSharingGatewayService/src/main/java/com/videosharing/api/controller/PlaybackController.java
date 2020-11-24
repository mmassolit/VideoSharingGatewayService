package com.videosharing.api.controller;

import com.videosharing.api.dto.PlaybackPayload;

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
    public PlaybackPayload create(@RequestBody PlaybackPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlaybackPayload> result = restTemplate.postForEntity(url, payload, PlaybackPayload.class);
        return result.getBody();
    }

    @GetMapping
    public List<PlaybackPayload> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PlaybackPayload>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public PlaybackPayload show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlaybackPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
    
    @DeleteMapping("{id}")
    public PlaybackPayload delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlaybackPayload> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    } 
}