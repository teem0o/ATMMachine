package com.finances.ATMMachine.repository;

import com.finances.ATMMachine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long Id);

    User findUserByUserName(String username);

    List<User> findAll();

    @Transactional
    @Modifying
    @Query("update User u set u.twoFaCode = :code, u.twoFaExpireTime = current_timestamp where u.id=:id")
    void updateTwoFaCode(@Param(value = "id") long id, @Param(value = "code") String code);

    @Query("select case when count(u)>0 THEN true ELSE false END from User u where u.twoFaCode=:code and u.id=:id and u.twoFaExpireTime>:time")
    boolean checkCode(@Param(value = "id") long id, @Param(value = "code") String code, long time);

}
