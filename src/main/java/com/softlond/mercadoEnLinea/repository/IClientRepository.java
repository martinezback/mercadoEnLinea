package com.softlond.mercadoEnLinea.repository;
import com.softlond.mercadoEnLinea.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT *FROM clients WHERE dni=:dni", nativeQuery = true)
    public Client findByDni(int dni);
}
