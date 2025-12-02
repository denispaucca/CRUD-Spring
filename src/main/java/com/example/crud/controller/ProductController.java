package com.example.crud.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.crud.model.Product;
import com.example.crud.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public List<Product> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Product save(@RequestBody Product p) { return service.save(p); }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) {
        Product existing = service.findById(id);
        if (existing == null) return null;
        existing.setName(p.getName());
        existing.setPrice(p.getPrice());
        existing.setStock(p.getStock());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
