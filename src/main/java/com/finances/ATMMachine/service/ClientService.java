package com.finances.ATMMachine.service;


import com.finances.ATMMachine.entity.Client;
import com.finances.ATMMachine.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(long Id){
        return clientRepository.findClientById(Id);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

}
