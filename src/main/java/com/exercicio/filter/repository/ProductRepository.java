package com.exercicio.filter.repository;

import com.exercicio.filter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository <Product, Long>{
}
