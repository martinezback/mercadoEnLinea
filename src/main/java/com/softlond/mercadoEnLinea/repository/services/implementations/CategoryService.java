package com.softlond.mercadoEnLinea.repository.services.implementations;

import com.softlond.mercadoEnLinea.entities.Category;
import com.softlond.mercadoEnLinea.exceptions.ConflictException;
import com.softlond.mercadoEnLinea.repository.ICategoryRepository;
import com.softlond.mercadoEnLinea.repository.services.contracts.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public ResponseEntity<?> create(Category category) {
        Category categorySave=createIfNotExist(category);
        return new ResponseEntity<>(categorySave, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Category> categoryFind=iCategoryRepository.findById(id);
        return new ResponseEntity<>(categoryFind,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Category>> getAll() {
        List<Category>categoryFind=iCategoryRepository.findAll();
        return new ResponseEntity<>(categoryFind,HttpStatus.OK);
    }

    private Category createIfNotExist(Category category) {

        if (!iCategoryRepository.existsById(1L)) {
            return iCategoryRepository.save(category);
        } else {
            if (iCategoryRepository.findByName(category.getName()) != null) {
                throw new ConflictException("categoria con nombre " + category.getName() + " ya existe");
            } else {
                return iCategoryRepository.save(category);
            }
        }
    }
}
