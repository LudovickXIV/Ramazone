package com.ramazone.ramazone;

import com.ramazone.ramazone.dto.ProductDTO;
import com.ramazone.ramazone.model.product.Product;

import java.util.List;

public interface ProductInterface {

    Product addProduct(ProductDTO product);

    Product getProduct(Integer id);

    Product getProduct(String productname);

    void updateProduct(int id, Product newProduct);

    void deleteProduct(int id);

    List<ProductDTO> getAllProducts();
}
