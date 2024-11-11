package com.example.codoceanbmongo.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentDTO {
    private String id;
    private String paymentMethod;
    private String paymentStatus;
    private String paymentDate;
    private String amount;
    private String currency;
    private String description;
}
