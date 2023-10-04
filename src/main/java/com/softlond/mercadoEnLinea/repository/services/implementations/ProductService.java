package com.softlond.mercadoEnLinea.repository.services.implementations;

import com.softlond.mercadoEnLinea.entities.Product;
import com.softlond.mercadoEnLinea.exceptions.ConflictException;
import com.softlond.mercadoEnLinea.repository.IProductRepository;
import com.softlond.mercadoEnLinea.repository.services.contracts.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public ResponseEntity<?> create(Product product) {
        Product product1=createIfNotExist(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Product> product= iProductRepository.findById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        List<Product>products=iProductRepository.findAll();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    private Product createIfNotExist(Product product) {

        if (!iProductRepository.existsById(1L)) {
            return iProductRepository.save(product);
        } else {
            if (iProductRepository.findByName(product.getName()) != null) {
                throw new ConflictException("Producto con nombre " + product.getName() + " ya existe");
            } else {
                return iProductRepository.save(product);
            }
        }
    }
}
