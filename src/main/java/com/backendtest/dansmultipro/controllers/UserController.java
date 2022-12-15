package com.backendtest.dansmultipro.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs() {
        List<Object> jobs = getExternalJobs();
        return ResponseEntity.ok(jobs);
    }

    private static List<Object> getExternalJobs() {
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";

        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(uri, Object[].class);

        return Arrays.asList(result);

    }
}
