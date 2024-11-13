package com.example.codoceanbmongo.payment.entity;

import com.example.codoceanbmongo.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Payment {
    @Id
    private String id;

    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime paymentDate;
    private Double amount;
    private String currency;
    private String description;

    @DBRef
    private User user;
}
