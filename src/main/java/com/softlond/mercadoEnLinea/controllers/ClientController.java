package com.softlond.mercadoEnLinea.controllers;
import com.softlond.mercadoEnLinea.entities.Client;
import com.softlond.mercadoEnLinea.repository.services.contracts.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClientService iClientService;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody @Valid Client client){

        return iClientService.create(client);
    }

    @GetMapping("/getById")
    public ResponseEntity<?>getById(@RequestParam Long id){
        return iClientService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Client>>getAllClients(){
        return iClientService.getAll();
    }
}
