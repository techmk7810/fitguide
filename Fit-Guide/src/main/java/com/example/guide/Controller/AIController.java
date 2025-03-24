package com.example.guide.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class AIController {

    @Value("${gemini.api.key}")  // Load API key from application.properties
    private String apiKey;

    private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent";

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<Map<String, String>> chat(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");

        // Construct request body correctly
        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("role", "user", "parts", List.of(Map.of("text", userMessage)))
                )
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Construct final URL with API key
        String fullUrl = GEMINI_API_URL + "?key=" + apiKey;
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, Map.class);

        String aiResponse = "No response";
        if (response.getBody() != null && response.getBody().get("candidates") != null) {
            aiResponse = ((List<Map<String, Object>>) response.getBody().get("candidates"))
                    .get(0).get("content").toString();
        }

        return ResponseEntity.ok(Map.of("reply", aiResponse));
    }
}
