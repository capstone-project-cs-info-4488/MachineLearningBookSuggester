package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthorController {

    private final String APIKEY;

    public AuthorController(Environment env) {
        APIKEY = env.getProperty("api.key");
    }

    @GetMapping("/author/{id}/show")
    public ResponseEntity<String> getAuthorById(@PathVariable String id,
                                                RestTemplate restTemplate) {
        final String URL = "https://www.goodreads.com/author/show.xml";
        return restTemplate.getForEntity(String.format("%s?id=%s&key=%s",
                URL, id, APIKEY), String.class);
    }

    @GetMapping("/author/{id}/series")
    public ResponseEntity<String> getAllSeriesByAuthorId(@PathVariable String id,
                                                         RestTemplate restTemplate) {
        final String URL = "https://www.goodreads.com/series/list";
        return restTemplate.getForEntity(String.format("%s?id=%s&key=%s",
                URL, id, APIKEY), String.class);
    }
}
