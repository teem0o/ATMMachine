package com.finances.ATMMachine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {
    private static final String username="555555";
    private static final String password = "***";


    public boolean sendSMS(String phone, String twoFaCode){
        // sending sms logic...
        log.info("{} -s code: {} ", phone,twoFaCode);
        return true;
    }
}