package edu.isu.capstone.bookrec.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan("edu.isu.capstone.bookrec.backend")
@SpringBootApplication(scanBasePackages = {"edu.isu.capstone.bookrec", "edu.isu.capstone.bookrec.recommender"})
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }
}
