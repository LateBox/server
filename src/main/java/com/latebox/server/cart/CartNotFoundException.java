package com.latebox.server.cart;

public class CartNotFoundException extends  RuntimeException {
    CartNotFoundException(Long id) {
        super("Could not find cart " + id);
    }
}
