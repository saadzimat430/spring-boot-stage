package com.ecommerce.ecommerce.dao;

import com.ecommerce.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


// @CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

    @Override
    @SuppressWarnings("unchecked")
    Product save(Product product);
}