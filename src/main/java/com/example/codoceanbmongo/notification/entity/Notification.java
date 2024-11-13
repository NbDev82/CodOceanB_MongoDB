package com.example.codoceanbmongo.notification.entity;

import com.example.codoceanbmongo.auth.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "notifications")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Notification implements Serializable {
    @Id
    private UUID id;

    private String content;

    private LocalDateTime receivingTime;

    private boolean isRead;

    private boolean isDelete;

    @DBRef
    private User recipient;
}
