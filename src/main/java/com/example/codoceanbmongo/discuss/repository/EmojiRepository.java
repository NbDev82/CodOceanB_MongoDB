package com.example.codoceanbmongo.discuss.repository;

import com.example.codoceanbmongo.discuss.entity.Emoji;
import com.example.codoceanbmongo.discuss.entity.EmojiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojiRepository extends MongoRepository<Emoji, String> {
}
