package com.softlond.mercadoEnLinea.controllers;

import com.softlond.mercadoEnLinea.entities.Product;
import com.softlond.mercadoEnLinea.repository.services.contracts.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid Product product){
        return iProductService.create(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>>getAllProducts(){
        return iProductService.getAll();
    }
}
