package com.latebox.server.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }

    @CrossOrigin
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @CrossOrigin
    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
    @CrossOrigin
    @GetMapping("/product/restaurant/{id}")
    Product oneByResto(@PathVariable Long id) {

        return repository.findByRestaurantId(id.toString()).stream().findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @CrossOrigin
    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setRestaurantId(newProduct.getRestaurantId());
                    product.setStock(newProduct.getStock());
                    product.setImageUri(newProduct.getImageUri());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ProductNotFoundException(id);
        }
    }
}

