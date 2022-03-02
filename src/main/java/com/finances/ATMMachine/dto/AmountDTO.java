package com.finances.ATMMachine.dto;

import lombok.Data;

@Data
public class AmountDTO {

    private String username;
    private String bankCode;
    private float amount;


    public AmountDTO(String username, String bankCode, float cashUSD) {
        this.username=username;
        this.bankCode=bankCode;
        this.amount=cashUSD;
    }
}
