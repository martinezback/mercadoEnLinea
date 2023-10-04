package com.softlond.mercadoEnLinea.repository;

import com.softlond.mercadoEnLinea.entities.Client;
import com.softlond.mercadoEnLinea.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT *FROM products WHERE name=:name", nativeQuery = true)
    public Product findByName(String name);
}
