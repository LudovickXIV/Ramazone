package com.ramazone.ramazone.service;

import com.ramazone.ramazone.ProductInterface;
import com.ramazone.ramazone.dto.ProductDTO;
import com.ramazone.ramazone.model.product.Product;
import com.ramazone.ramazone.repo.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductInterface {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Product addProduct(ProductDTO productDto) {
        Product product = getProduct(productDto.getProductname());
        if (product != null) {
            return null;
        }

        product = new Product();
        product = mapper.map(productDto, Product.class);
        product.setProductname(product.getProductname());
        product.setDiscription(product.getDiscription());
        product.setPrice(product.getPrice());

        repository.save(product);
        return product;
    }

    @Override
    public Product getProduct(Integer id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException());
        return product;
    }

    @Override
    public Product getProduct(String productname) {
       Product pruductFromDb = repository.findByProductname(productname);
       try {
           ProductDTO dto = mapper.map(pruductFromDb, ProductDTO.class);
       } catch (Exception e) {}
       return pruductFromDb;
    }

    @Override
    public void updateProduct(int id, Product newProduct) {
    }

    @Override
    public void deleteProduct(int id) {
        repository.delete(getProduct(id));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        Iterable<Product> products = repository.findAll();
        List<Product> dtos = (List<Product>) products;
        return dtos.stream()
                .map(product -> convertToDto(product))
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDto(Product product){
        ProductDTO productDTO = mapper.map(product, ProductDTO.class);
        return productDTO;
    }
}
