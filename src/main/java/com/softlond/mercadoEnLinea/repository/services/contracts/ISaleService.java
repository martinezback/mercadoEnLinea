package com.softlond.mercadoEnLinea.repository.services.contracts;

import com.softlond.mercadoEnLinea.entities.Sale;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISaleService {
    public ResponseEntity<?> create(Sale sale);
    public ResponseEntity<?>getById(Long id);
    public ResponseEntity<List<Sale>>getAll();


}
