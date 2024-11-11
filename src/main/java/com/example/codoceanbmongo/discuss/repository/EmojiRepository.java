package com.example.codoceanbmongo.discuss.repository;

import com.example.codoceanbmongo.discuss.entity.Emoji;
import com.example.codoceanbmongo.discuss.entity.EmojiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmojiRepository extends JpaRepository<Emoji, EmojiId> {
}
