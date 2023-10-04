package com.softlond.mercadoEnLinea.controllers;

import com.softlond.mercadoEnLinea.entities.Sale;
import com.softlond.mercadoEnLinea.repository.services.contracts.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleService iSaleService;

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody Sale sale){
        return iSaleService.create(sale);
    }

    @GetMapping
    public ResponseEntity<List<Sale>>getAllSales(){
        return iSaleService.getAll();
    }
}
