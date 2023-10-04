package com.softlond.mercadoEnLinea.controllers;

import com.softlond.mercadoEnLinea.entities.SaleDetail;
import com.softlond.mercadoEnLinea.repository.services.contracts.ISaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saledetails")
public class SaleDetailController {

    @Autowired
    private ISaleDetailService iSaleDetailService;

    @PostMapping
    public ResponseEntity<?> createSaleDetail(@RequestBody SaleDetail saleDetail){
        return iSaleDetailService.create(saleDetail);
    }

    @GetMapping
    public ResponseEntity<List<SaleDetail>>getAllSaleDetails(){
        return iSaleDetailService.getAll();
    }
}
