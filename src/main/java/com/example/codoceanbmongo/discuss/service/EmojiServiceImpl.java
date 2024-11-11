package com.example.codoceanbmongo.discuss.service;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.auth.service.UserService;
import com.example.codoceanbmongo.discuss.entity.Discuss;
import com.example.codoceanbmongo.discuss.entity.Emoji;
import com.example.codoceanbmongo.discuss.entity.EmojiId;
import com.example.codoceanbmongo.discuss.repository.EmojiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmojiServiceImpl implements EmojiService{

    @Autowired
    private EmojiRepository emojiRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussService discussService;

    @Override
    public void addEmoji(String authHeader, UUID discussId) {
        User owner = userService.getUserDetailsFromToken(authHeader);
        Discuss discuss = discussService.getDiscuss(discussId);
        EmojiId id = EmojiId.builder()
                .owner(owner.getId())
                .discuss(discussId)
                .build();

        if(!emojiRepository.existsById(id)) {
            Emoji emoji = Emoji.builder()
                    .owner(owner)
                    .discuss(discuss)
                    .build();
            emojiRepository.save(emoji);
        }
    }

    @Override
    public void deleteEmoji(String authHeader, UUID discussId) {
        User owner = userService.getUserDetailsFromToken(authHeader);
        EmojiId id = EmojiId.builder()
                .owner(owner.getId())
                .discuss(discussId)
                .build();

        emojiRepository.deleteById(id);
    }
}
