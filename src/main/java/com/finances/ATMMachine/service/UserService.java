package com.finances.ATMMachine.service;


import com.finances.ATMMachine.dto.AmountDTO;
import com.finances.ATMMachine.entity.User;
import com.finances.ATMMachine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(long Id) {
        return userRepository.findUserById(Id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    //  TODO
    public User deposit(AmountDTO amount) {
        System.out.println(amount.getAmount());
        return new User();
    }

    public User getUserByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void updateTwoFaCode( long id, String code){
        userRepository.updateTwoFaCode(id,code);
    }
    public boolean checkCode(long id, String code){
        return userRepository.checkCode(id,code,System.currentTimeMillis()/1000);
    }
}
