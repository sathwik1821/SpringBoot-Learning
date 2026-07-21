package com.codingshuttle.sathwik.jpaTutorial.controllers;


import com.codingshuttle.sathwik.jpaTutorial.entites.ProductEntity;
import com.codingshuttle.sathwik.jpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @GetMapping(path = "/getAll")
    public List<ProductEntity> getAll(@RequestParam(defaultValue = "id") String sortBy) {
        return productRepository.findAll(Sort.by(sortBy));
    }

    @GetMapping(path = "/{productName}")
    public List<ProductEntity> getProductByName(@PathVariable String productName){
        return productRepository.findByTitle(productName);
    }
}
