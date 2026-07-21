package com.codingshuttle.sathwik.jpaTutorial.controllers;


import com.codingshuttle.sathwik.jpaTutorial.entites.ProductEntity;
import com.codingshuttle.sathwik.jpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    final ProductRepository productRepository;

    final int PAGE_SIZE=5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }



    @GetMapping(path = "/getAll")
    public List<ProductEntity> getAll(@RequestParam(defaultValue = "1") String sortBy,
                                      @RequestParam(defaultValue = "1") Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy).ascending());
        return productRepository.findAll(pageable).getContent();
    }

    @GetMapping(path = "/{productName}")
    public List<ProductEntity> getProductByName(@PathVariable String productName){
        return productRepository.findByTitle(productName);
    }
}
