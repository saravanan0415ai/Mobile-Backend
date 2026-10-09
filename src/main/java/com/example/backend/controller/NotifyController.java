package com.example.backend.controller;

import com.example.backend.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/notify")
@CrossOrigin(origins = "*")
public class NotifyController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/guest-recharge")
    public ResponseEntity<String> notifyGuestRecharge() {
        // Send SMS to the specific admin number
        smsService.sendGuestRechargeAlert("+918220408593");
        return ResponseEntity.ok("Notification sent successfully");
    }
}

