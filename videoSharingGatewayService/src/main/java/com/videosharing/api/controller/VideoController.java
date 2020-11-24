package com.videosharing.api.controller;

import com.videosharing.api.dto.VideoPayload;
import com.videosharing.model.Video;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/video")
@NoArgsConstructor
public class VideoController {

    private final String url = "http://videos:8084/video";

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody VideoPayload payload) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Video> result = restTemplate.postForEntity(url, payload, Video.class);
        return result;
    }

    @GetMapping
    public ResponseEntity<List<Video>> index() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Video>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    }

    @GetMapping("{id}")
    public ResponseEntity<Video> show(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Video> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Video> delete(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Video> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result;
    } 
}