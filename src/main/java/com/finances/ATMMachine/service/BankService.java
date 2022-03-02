package com.finances.ATMMachine.service;


import com.finances.ATMMachine.dto.AmountDTO;
import com.finances.ATMMachine.entity.Bank;
import com.finances.ATMMachine.entity.User;
import com.finances.ATMMachine.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private UserService userService;

    public Bank findBankByUserAndIbanCode(User user, String ibanCOde) {
        return bankRepository.findBankByUserAndIbanCode(user, ibanCOde);
    }

    public Bank deposit(String bankCode, float amount) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.getUserByUserName(username);

        Bank bank = findBankByUserAndIbanCode(user, bankCode);
        bankRepository.setAmount(bankCode, bank.getCashUSD() + amount);
        return bank;
    }


    public Bank withDraw(String bankCode, float amount)  {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.getUserByUserName(username);
        Bank bank = findBankByUserAndIbanCode(user, bankCode);
        if (bank.getCashUSD()<amount){
            throw new IllegalStateException("not enough money");
        }
        bankRepository.setAmount(bankCode, bank.getCashUSD() - amount);
        return bank;
    }

    public AmountDTO checkBalance(String bankCode) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.getUserByUserName(username);
        Bank bank = findBankByUserAndIbanCode(user, bankCode);
        return new AmountDTO(username,bankCode,bank.getCashUSD());

    }
}
