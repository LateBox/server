package com.latebox.server.restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/restaurants")
    List<Restaurant> all(){
        return repository.findAll();
    }

    @PostMapping("/restaurants")
    Restaurant newRestaurant(@RequestBody Restaurant newRestaurant){
        return repository.save(newRestaurant);
    }

    @GetMapping("/restaurants/{id}")
    Restaurant one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @PutMapping("/restaurants/{id}")
    Restaurant replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable Long id) {

        return repository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(newRestaurant.getName());
                    restaurant.setDescription(newRestaurant.getDescription());
                    restaurant.setAddress(newRestaurant.getAddress());
                    restaurant.setCity(newRestaurant.getCity());
                    restaurant.setCountry(newRestaurant.getCountry());
                    return repository.save(restaurant);
                })
                .orElseGet(() -> {
                    newRestaurant.setId(id);
                    return repository.save(newRestaurant);
                });
    }

    @DeleteMapping("/restaurants/{id}")
    void deleteRestaurant(@PathVariable Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new RestaurantNotFoundException(id);
        }
    }
}

