package com.codingshuttle.sathwik.jpaTutorial.repositories;

import com.codingshuttle.sathwik.jpaTutorial.entites.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByTitle(String productName);
}
