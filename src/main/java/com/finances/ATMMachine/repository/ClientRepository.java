package com.finances.ATMMachine.repository;

import com.finances.ATMMachine.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    public Client findClientById(Long Id);
}
