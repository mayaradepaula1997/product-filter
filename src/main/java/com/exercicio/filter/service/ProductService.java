package com.exercicio.filter.service;


import com.exercicio.filter.entity.Product;
import com.exercicio.filter.entity.dto.CreateProduct;
import com.exercicio.filter.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product create (CreateProduct createProduct){

        Product product = new Product();

        product.setName(createProduct.name());
        product.setPrice(createProduct.price());

        return productRepository.save(product);

    }
}
