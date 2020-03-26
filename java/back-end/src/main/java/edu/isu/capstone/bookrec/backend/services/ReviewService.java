package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService extends CrudRepository<Review, Long> {
}
