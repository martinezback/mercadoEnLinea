package com.softlond.mercadoEnLinea.repository.services.implementations;

import com.softlond.mercadoEnLinea.entities.SaleDetail;
import com.softlond.mercadoEnLinea.repository.services.contracts.ISaleDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SailDetailService implements ISaleDetailService {

    @Override
    public ResponseEntity<?> create(SaleDetail saleDetail) {
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<SaleDetail>> getAll() {
        return null;
    }
}
