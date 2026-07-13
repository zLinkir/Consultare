package com.consultare.digitalbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "API Online!";
    }

    @GetMapping("/info")
    public Map<String, String> info() {

        Map<String, String> response = new HashMap<>();

        response.put("status", "UP");
        response.put("application", "Digital Bank API");

        return response;
    }

}
