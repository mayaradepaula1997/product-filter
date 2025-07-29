package com.exercicio.filter.utils;

import com.exercicio.filter.entity.Product;
import com.exercicio.filter.entity.dto.ProductFilterDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Product> comFiltros(ProductFilterDTO productFilterDTO){
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();


            if (productFilterDTO.name() != null && !productFilterDTO.name().isBlank()){

                predicates.add(cb.like(cb.lower(root.get("name")), "%" + productFilterDTO.name().toLowerCase() + "%"));
            }

//
            if (productFilterDTO.priceMin() != null){    //Verifica se o usuário informou um preço mínimo para o filtro

                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), productFilterDTO.priceMin()));

                //greaterThanOrEqualTo: Cria uma condição >= (maior ou igual)
                //estamos dizendo: “pegue o valor da coluna price da tabela de produtos”.
            }


            if (productFilterDTO.priceMax() != null)   //Verifica se o usuário informou um preço mínimo para o filtro

                predicates.add(cb.lessThanOrEqualTo(root.get("price"), productFilterDTO.priceMax()));

                //cb.lessThanOrEqualTo: Cria uma condição <= (menor ou igual)



            return cb.and(predicates.toArray(new Predicate[0]));


        };
    }

}
















