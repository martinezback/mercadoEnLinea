package com.softlond.mercadoEnLinea.repository.services.contracts;

import com.softlond.mercadoEnLinea.entities.Category;
import com.softlond.mercadoEnLinea.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    public ResponseEntity<?> create(Category category);
    public ResponseEntity<?>getById(Long id);

    public ResponseEntity<List<Category>>getAll();
}
