package com.softlond.mercadoEnLinea.repository.services.contracts;

import com.softlond.mercadoEnLinea.entities.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IClientService {
    public ResponseEntity<?> create(Client client);
    public ResponseEntity<?>getById(Long id);

    public ResponseEntity<List<Client>>getAll();

}
