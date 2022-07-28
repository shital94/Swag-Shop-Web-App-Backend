package com.revature.services;

import com.revature.models.Review;
import com.revature.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByProduct (Integer productId) {
        return reviewRepository.getReviewsByProduct(productId);
    }

    public void createReview (Review review) {
        reviewRepository.save(review);
    }


}
