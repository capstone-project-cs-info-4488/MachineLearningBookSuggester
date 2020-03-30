//package edu.isu.capstone.bookrec.backend.configuration;
//
//import edu.isu.capstone.bookrec.recommender.BookRecommender;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class BookRecommenderConfig {
//    private static final Logger logger = LoggerFactory.getLogger(BookRecommenderConfig.class);
//
//    @Bean
//    public BookRecommender getBookRecommender() throws IOException {
//        logger.info("Creating book recommender");
//        long start = System.currentTimeMillis();
//        BookRecommender recommender = BookRecommender.createDefault();
//        long elapsed = System.currentTimeMillis() - start;
//        logger.info("Created book recommender in {} ms", elapsed);
//
//        return recommender;
//    }
//}
