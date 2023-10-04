package com.softlond.mercadoEnLinea.repository.services.contracts;

import com.softlond.mercadoEnLinea.entities.Client;
import com.softlond.mercadoEnLinea.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface IProductService {

    public ResponseEntity<?>create(Product product);
    public ResponseEntity<?>getById(Long id);
    public ResponseEntity<List<Product>>getAll();
}
