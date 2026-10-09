package com.example.backend.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class SmsService {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.phone_number}")
    private String fromPhoneNumber;

    @PostConstruct
    public void init() {
        if (accountSid != null && !accountSid.isEmpty() && !accountSid.equals("your_account_sid")) {
            Twilio.init(accountSid, authToken);
        }
    }

    public void sendGuestRechargeAlert(String toNumber) {
        if (accountSid == null || accountSid.isEmpty() || accountSid.equals("your_account_sid")) {
            System.out.println("Twilio is not configured. Simulating SMS to " + toNumber);
            System.out.println("Message: Guest User attempted to perform a mobile recharge. Please check the system.");
            return;
        }
        
        try {
            Message message = Message.creator(
                    new PhoneNumber(toNumber),
                    new PhoneNumber(fromPhoneNumber),
                    "Guest User attempted to perform a mobile recharge. Please check the system."
            ).create();
            System.out.println("Guest recharge alert SMS sent. SID: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Failed to send SMS: " + e.getMessage());
        }
    }
}

