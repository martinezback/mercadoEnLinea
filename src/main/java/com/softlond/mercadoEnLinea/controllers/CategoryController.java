package com.softlond.mercadoEnLinea.controllers;

import com.softlond.mercadoEnLinea.entities.Category;
import com.softlond.mercadoEnLinea.repository.services.contracts.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @PostMapping
    public ResponseEntity<?>createCategory(@RequestBody @Valid Category category){
        return iCategoryService.create(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>>getAllCategory(){
        return iCategoryService.getAll();
    }
}
