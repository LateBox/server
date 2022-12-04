package com.latebox.server.product;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(Long id) {
        super("Could not find product " + id);
    }

    public ProductNotFoundException() {
        super("Could not find product ");
    }
}
