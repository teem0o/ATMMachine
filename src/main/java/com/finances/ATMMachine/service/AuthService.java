package com.finances.ATMMachine.service;

import com.finances.ATMMachine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void updateTwoFaCode( long id, String code){
        userRepository.updateTwoFaCode(id,code,(System.currentTimeMillis()/1000) + 120);
    }
    public boolean checkCode(long id, String code){
        return userRepository.checkCode(id,code,System.currentTimeMillis()/1000);
    }
}
