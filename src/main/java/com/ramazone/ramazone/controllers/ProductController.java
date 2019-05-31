package com.ramazone.ramazone.controllers;

import com.ramazone.ramazone.dto.ProductDTO;
import com.ramazone.ramazone.model.product.Product;
import com.ramazone.ramazone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public String insertProduct(@RequestBody ProductDTO product) {
         service.addProduct(product);
         return "null";
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return service.getProduct(id);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return service.getAllProducts();
    }
}
