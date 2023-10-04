package com.softlond.mercadoEnLinea.repository;

import com.softlond.mercadoEnLinea.entities.Category;
import com.softlond.mercadoEnLinea.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT *FROM categories WHERE name=:name", nativeQuery = true)
    public Category findByName(String name );
}
