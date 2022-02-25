package com.latebox.server.foodorder;

public class FoodOrderNotFoundException extends  RuntimeException {
    FoodOrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}
