package com.example.codoceanbmongo.auth.repository;

import com.example.codoceanbmongo.auth.entity.Token;
import com.example.codoceanbmongo.auth.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepos extends MongoRepository<Token, UUID> {
    void deleteByToken(String token);

    Optional<Token> findByToken(String token);

    Token findByUser(User user);

    void deleteByUser(User user);
}
