package com.finances.ATMMachine.service;


import com.finances.ATMMachine.dto.AmountDTO;
import com.finances.ATMMachine.entity.User;
import com.finances.ATMMachine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
