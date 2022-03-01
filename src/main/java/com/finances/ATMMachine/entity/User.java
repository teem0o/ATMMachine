package com.finances.ATMMachine.entity;

import lombok.Data;

import javax.persistence.*;

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
    private String pin;
    private String fingerprintCode;
    private String textCode;
    private String authenticationType;


    //    @OneToMany(mappedBy = "user")
//    private List<Bank> banks;
}
