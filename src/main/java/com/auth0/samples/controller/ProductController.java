package com.auth0.samples.controller;

import com.auth0.samples.model.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product("Coca-cola", BigDecimal.valueOf(2.36)));
        products.add(new Product("Bread", BigDecimal.valueOf(1.7)));
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        products.add(product);
    }

    @DeleteMapping("/{index}")
    public void deleteProduct(@PathVariable int index) {
        products.remove(index);
    }
}
