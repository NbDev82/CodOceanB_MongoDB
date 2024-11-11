package com.example.codoceanbmongo.payment.service;

import com.example.codoceanbmongo.payment.dto.PaymentDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    List<PaymentDTO> getPayments(String authHeader);

    PaymentDTO getPayment(UUID id);
}
