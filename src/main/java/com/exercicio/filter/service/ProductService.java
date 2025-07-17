package com.exercicio.filter.service;


import com.exercicio.filter.entity.Product;
import com.exercicio.filter.entity.dto.CreateProduct;
import com.exercicio.filter.entity.dto.UpdateProduct;
import com.exercicio.filter.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



    public List<Product> list(){

        Sort sort = Sort.by("name").ascending()                 //consulta ordenada
                .and(Sort.by("price").descending());

        return productRepository.findAll(sort);
    }



    public Product update(Long id ,UpdateProduct updateProduct) throws Exception {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){

            Product product = optionalProduct.get();

            product.setName(updateProduct.name());
            product.setPrice(updateProduct.price());

            return productRepository.save(product);

        }

        else throw new Exception("Product not found");

    }


    public void delete(Long id) throws Exception {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){

            productRepository.deleteById(id);
        }

        else throw new Exception("Product not found");

    }
}
