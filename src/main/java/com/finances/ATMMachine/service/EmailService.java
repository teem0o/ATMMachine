package com.finances.ATMMachine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    private static final String username="temo@gmail.com";
    private static final String password = "***";


    public boolean sendEmail(String email, String twoFaCode){
        // sending email logic...
        log.info("{} -s code: {} ", email,twoFaCode);
        return true;
    }
}
