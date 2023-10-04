package com.softlond.mercadoEnLinea.repository;

import com.softlond.mercadoEnLinea.entities.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISaleDetailRepository extends JpaRepository<SaleDetail, Long> {
}
