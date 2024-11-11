package com.example.codoceanbmongo.auth.repository;

import com.example.codoceanbmongo.auth.entity.Token;
import com.example.codoceanbmongo.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepos extends JpaRepository<Token, UUID> {
    void deleteByToken(String token);

    Optional<Token> findByToken(String refreshToken);

    Token findByUser(User user);

    void deleteByUser(User user);
}
