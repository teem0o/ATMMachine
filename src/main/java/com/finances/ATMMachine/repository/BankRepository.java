package com.finances.ATMMachine.repository;

import com.finances.ATMMachine.entity.Bank;
import com.finances.ATMMachine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {


    Bank findBankByUserAndIbanCode(User user,String ibanCode);

    @Transactional
    @Modifying
    @Query("update Bank b set b.cashUSD = :amount where b.ibanCode=:ibanCode")
    void setAmount(String ibanCode,float amount);
}
