package com.finances.ATMMachine.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    private String IbanCode;
    private float cashUSD;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
