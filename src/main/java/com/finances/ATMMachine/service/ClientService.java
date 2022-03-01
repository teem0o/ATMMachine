package com.finances.ATMMachine.service;


import com.finances.ATMMachine.dto.AmountDTO;
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

    //  TODO
    public Client deposit(AmountDTO amount) {
        System.out.println(amount.getAmount());
        return new Client();
    }
}
