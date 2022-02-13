package com.latebox.server.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all(){
        return repository.findAll();
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    Product replaceEmployee(@RequestBody Product newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setDescription(newEmployee.getDescription());
                    employee.setPrice(newEmployee.getPrice());
                    employee.setRestaurantId(newEmployee.getRestaurantId());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

