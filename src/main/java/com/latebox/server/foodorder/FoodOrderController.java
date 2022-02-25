package com.latebox.server.foodorder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodOrderController {

    private final FoodOrderRepository repository;

    public FoodOrderController(FoodOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    List<FoodOrder> all(){
        return repository.findAll();
    }

    @PostMapping("/orders")
    FoodOrder newOrder(@RequestBody FoodOrder newOrder){
        return repository.save(newOrder);
    }

    @GetMapping("/orders/{id}")
    FoodOrder one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new FoodOrderNotFoundException(id));
    }

    @PutMapping("/orders/{id}")
    FoodOrder replaceOrder(@RequestBody FoodOrder newOrder, @PathVariable Long id) {

        return repository.findById(id)
                .map(order -> {
                    order.setUserId(newOrder.getUserId());
                    order.setRestaurantId(newOrder.getRestaurantId());
                    order.setItemIdsList(newOrder.getItemIdsList());
                    order.setTimestamp(newOrder.getTimestamp());
                    order.setPaymentMethod(newOrder.getPaymentMethod());
                    order.setPickedUp(newOrder.getPickedUp());
                    return repository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return repository.save(newOrder);
                });
    }

    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new FoodOrderNotFoundException(id);
        }
    }
}

