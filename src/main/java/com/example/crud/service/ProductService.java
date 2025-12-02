package com.example.crud.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() { return repository.findAll(); }

    public Product save(Product product) { return repository.save(product); }

    public Product findById(Long id) { return repository.findById(id).orElse(null); }

    public void delete(Long id) { repository.deleteById(id); }
}
