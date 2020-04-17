package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    private final String URL = "https://www.goodreads.com/search/index.xml";
    private final String APIKEY;

    public BookController(Environment env) {
        APIKEY = env.getProperty("api.key");
    }


    @GetMapping("/book/id/{id}/show")
    public ResponseEntity<String> getBookById(@PathVariable String id,
                                              RestTemplate restTemplate) {
        return restTemplate.getForEntity(String.format("%s?q=%s&search=id&key=%s",
                URL, id, APIKEY), String.class);
    }

    @GetMapping("/book/title/{title}/show")
    public ResponseEntity<String> getBookByTitle(@PathVariable String title,
                                                 RestTemplate restTemplate) {
        return restTemplate.getForEntity(String.format("%s?q=%s&search=title&key=%s",
                URL, title, APIKEY), String.class);
    }

    @GetMapping("/book/isbn/{isbn}/show")
    public ResponseEntity<String> getBookByIsbn(@PathVariable String isbn,
                                                RestTemplate restTemplate) {
        return restTemplate.getForEntity(String.format("%s?q=%s&search=isbn&key=%s",
                URL, isbn, APIKEY), String.class);
    }

    @GetMapping("/book/search/{query}")
    public ResponseEntity<String> searchAllBooks(@PathVariable String query,
                                                 RestTemplate restTemplate) {
        return restTemplate.getForEntity(String.format("%s?q=%s&key=%s",
                URL, query, APIKEY), String.class);
    }

    @GetMapping("/book/id/{id}/reviews")
    public ResponseEntity<String> getReviewsForBookById(@PathVariable String id,
                                                        RestTemplate restTemplate) {
        final String URL = "https://goodreads.com/book/show";
        return restTemplate.getForEntity(String.format("%s?id=%s&key=%s",
                URL, id, APIKEY), String.class);
    }
}
