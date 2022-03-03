package com.latebox.server.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewRepository repository;

    public ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reviews")
    List<Review> all(){
        return repository.findAll();
    }

    @PostMapping("/reviews")
    Review newReview(@RequestBody Review newReview){
        return repository.save(newReview);
    }

    @GetMapping("/reviews/{id}")
    Review one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @PutMapping("/reviews/{id}")
    Review replaceReview(@RequestBody Review newReview, @PathVariable Long id) {

        return repository.findById(id)
                .map(review -> {
                    review.setUserId(newReview.getUserId());
                    review.setRestaurantId(newReview.getRestaurantId());
                    review.setOrderId(newReview.getOrderId());
                    review.setStarRating(newReview.getStarRating());
                    review.setComments(newReview.getComments());
                    review.setDate(newReview.getDate());
                    return repository.save(review);
                })
                .orElseGet(() -> {
                    newReview.setId(id);
                    return repository.save(newReview);
                });
    }

    @DeleteMapping("/reviews/{id}")
    void deleteReview(@PathVariable Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new ReviewNotFoundException(id);
        }
    }
}

