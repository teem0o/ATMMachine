package com.finances.ATMMachine.entity;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    private String IbanCode;
    private float cashUSD;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIbanCode() {
        return IbanCode;
    }

    public void setIbanCode(String ibanCode) {
        IbanCode = ibanCode;
    }

    public float getCashUSD() {
        return cashUSD;
    }

    public void setCashUSD(float cashUSD) {
        this.cashUSD = cashUSD;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
