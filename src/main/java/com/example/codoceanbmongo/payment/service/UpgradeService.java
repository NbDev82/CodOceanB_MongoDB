package com.example.codoceanbmongo.payment.service;

import com.example.codoceanbmongo.payment.dto.PaymentDTO;
import com.example.codoceanbmongo.payment.request.UpgradeRequest;

public interface UpgradeService {
    String processUpgradeRequest(UpgradeRequest upgradeRequest);
    String executePayment(String authHeader, String token, String payerId);
    PaymentDTO getInfoOrder(String token);
}
