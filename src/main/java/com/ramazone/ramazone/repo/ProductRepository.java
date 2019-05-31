package com.ramazone.ramazone.repo;

import com.ramazone.ramazone.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductname(String productname);
}
