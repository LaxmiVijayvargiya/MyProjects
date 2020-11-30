package com.products.controller;

import com.products.model.Products;
import com.products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class DemoInventoryController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping(value = "/productDetails")
    public ResponseEntity<List<Products>> getAllProductDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(productsRepository.findAll());
    }

    @GetMapping(value = "/productDetail")
    public ResponseEntity<Optional<Products>> getAllProductDetails(@RequestParam Integer productid){
        return ResponseEntity.status(HttpStatus.OK).body(productsRepository.findById(productid));
    }

    @PostMapping(value = "/addProduct",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addProduct(@RequestBody Products product){
        productsRepository.save(product);
        String message = "New product inserted";
        /*return new ResponseEntity<String>(message, HttpStatus.CREATED);*/
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping(value = "/updateProduct",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateProduct(@RequestBody Products product){
        productsRepository.save(product);
        String message = "Product updated";
        /*return new ResponseEntity<String>(message, HttpStatus.CREATED);*/
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @DeleteMapping(value = "/deleteProduct",produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteProduct(@RequestParam Integer productid){
        productsRepository.deleteById(productid);
        String message = "Product deleted";
        /*return new ResponseEntity<String>(message, HttpStatus.CREATED);*/
        return message;
    }
}
