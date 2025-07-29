package com.exercicio.filter.repository;

import com.exercicio.filter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository  extends JpaRepository <Product, Long> , JpaSpecificationExecutor<Product> {
}



