package com.softlond.mercadoEnLinea.repository.services.contracts;

import com.softlond.mercadoEnLinea.entities.SaleDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ISaleDetailService {
    public ResponseEntity<?> create(SaleDetail saleDetail);
    public ResponseEntity<?>getById(Long id);
    public ResponseEntity<List<SaleDetail>>getAll();
}
