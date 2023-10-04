package com.softlond.mercadoEnLinea.repository;

import com.softlond.mercadoEnLinea.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface ISaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT *FROM sales WHERE dateSale=:date", nativeQuery = true)
    public List<Sale> findByDate(LocalDate date);

    @Query(value = "SELECT *FROM sales WHERE client_id=:id", nativeQuery = true)
    public List<Sale>findByClientId(Long id);

    @Query(value = "SELECT * FROM sales WHERE client_id=:customerId " +
            "AND date_sale BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Sale>findByClientIdAndDateBetween(Long customerId, LocalDate startDate, LocalDate endDate);

}
