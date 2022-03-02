package com.finances.ATMMachine.entity;

import com.finances.ATMMachine.enums.AuthenticationType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phone;

    // sus
    private AuthenticationType authenticationType;
    private String twoFaCode;
    private Long twoFaExpireTime;
//    private LocalDateTime twoFaExpireTime;
//    private String pin;
//    private String fingerprintCode;


    //    @OneToMany(mappedBy = "user")
//    private List<Bank> banks;
}
