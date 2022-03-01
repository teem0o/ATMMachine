package com.finances.ATMMachine.repository;

import com.finances.ATMMachine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long Id);
    User findUserByUserName(String username);
    List<User> findAll();

}
