//package edu.isu.capstone.bookrec.backend.controllers;
//
//import edu.isu.capstone.bookrec.backend.services.RecommenderService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Set;
//
//@RestController
//public class RecommenderController {
//    private final RecommenderService recommender;
//
//    public RecommenderController(RecommenderService recommender) {
//        this.recommender = recommender;
//    }
//
//    @GetMapping("/user/{userId}/recommend")
//    public Set<Long> recommendBooks(@PathVariable long userId) {
//        return recommender.recommendBooks(userId);
//    }
//}
