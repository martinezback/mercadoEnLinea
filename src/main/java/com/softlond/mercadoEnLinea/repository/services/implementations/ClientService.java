package com.softlond.mercadoEnLinea.repository.services.implementations;

import com.softlond.mercadoEnLinea.entities.Client;
import com.softlond.mercadoEnLinea.exceptions.ConflictException;
import com.softlond.mercadoEnLinea.repository.IClientRepository;
import com.softlond.mercadoEnLinea.repository.services.contracts.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;


    @Override
    public ResponseEntity<?> create(Client client) {
        Client clientSaved= createIfNotExist(client);
        return new ResponseEntity<>(clientSaved,HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Client> clientFind=iClientRepository.findById(id);
        if(clientFind.isEmpty()){
        }
        return new ResponseEntity<>(clientFind, HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<Client>> getAll() {
        List<Client>clients=iClientRepository.findAll();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }


    private Client createIfNotExist(Client client){

        if(!iClientRepository.existsById(1L)){
            return iClientRepository.save(client);
        }else{
            if(iClientRepository.findByDni(client.getDni())!=null){
                throw new ConflictException("Cliente con dni "+client.getDni()+" ya existe");
            }else{
                return iClientRepository.save(client);
            }
        }
    }
}
