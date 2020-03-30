package edu.isu.capstone.bookrec.backend.configuration;

import edu.isu.capstone.bookrec.recommender.BookRecommender;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.io.IOException;

@Configuration
public class BookRecommenderConfig {
    private static final Logger logger = LoggerFactory.getLogger(BookRecommenderConfig.class);

    @Bean
    public BookRecommender getBookRecommender(BookRecommenderConfigProperties config) throws IOException {
        logger.info("Creating book recommender");
        long start = System.currentTimeMillis();
        BookRecommender recommender = BookRecommender.createFromResourcePath(config.getTrainingDataResource(), config.getMinSupport());
        long elapsed = System.currentTimeMillis() - start;
        logger.info("Created book recommender in {} ms", elapsed);

        return recommender;
    }

    @Validated
    @ConstructorBinding
    @ConfigurationProperties("recommender")
    @Data
    public static class BookRecommenderConfigProperties {
        private final String trainingDataResource;

        @Min(1)
        private final int minSupport;
    }
}
