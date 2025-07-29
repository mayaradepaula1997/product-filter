package com.exercicio.filter.controller;



import com.exercicio.filter.entity.Product;
import com.exercicio.filter.entity.dto.CreateProduct;
import com.exercicio.filter.entity.dto.ProductFilterDTO;
import com.exercicio.filter.entity.dto.UpdateProduct;
import com.exercicio.filter.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController( ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProduct createProduct){

      Product product = productService.create(createProduct);

      return ResponseEntity.ok(product);
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody UpdateProduct updateProduct) throws Exception {

       if (id == null || id <= 0){

           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }

       Product product = productService.update(id,updateProduct);

       return ResponseEntity.ok(product);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete (@PathVariable Long id) throws Exception {

        if (id == null || id <= 0){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity <List<Product>> findAll(){

        List<Product> productsList = productService.list();

        return ResponseEntity.ok().body(productsList);


    }


    @GetMapping("/filter")

    public List<Product> filtar(ProductFilterDTO productFilterDTO){

        return productService.filter(productFilterDTO);
    }




}
