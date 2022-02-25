package com.latebox.server.cart;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartRepository repository;

    public CartController(CartRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/carts")
    List<Cart> all(){
        return repository.findAll();
    }

    @PostMapping("/carts")
    Cart newCart(@RequestBody Cart newCart){
        return repository.save(newCart);
    }

    @GetMapping("/carts/{id}")
    Cart one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
    }

    @PutMapping("/carts/{id}")
    Cart replaceCart(@RequestBody Cart newCart, @PathVariable Long id) {

        return repository.findById(id)
                .map(cart -> {
                    cart.setUserId(newCart.getUserId());
                    cart.setRestaurantId(newCart.getRestaurantId());
                    cart.setItemIdsList(newCart.getItemIdsList());
                    return repository.save(cart);
                })
                .orElseGet(() -> {
                    newCart.setId(id);
                    return repository.save(newCart);
                });
    }

    @DeleteMapping("/carts/{id}")
    void deleteCart(@PathVariable Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new CartNotFoundException(id);
        }
    }
}

