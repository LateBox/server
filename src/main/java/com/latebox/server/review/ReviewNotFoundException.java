package com.latebox.server.review;

public class ReviewNotFoundException extends  RuntimeException {
    ReviewNotFoundException(Long id) {
        super("Could not find review " + id);
    }
}
