package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String operator;
    private Long planId;
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paymentDate = LocalDateTime.now();
}
