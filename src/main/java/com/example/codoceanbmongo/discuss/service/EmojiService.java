package com.example.codoceanbmongo.discuss.service;

import java.util.UUID;

public interface EmojiService {
    void addEmoji(String authHeader, UUID problemId);
    void deleteEmoji(String authHeader, UUID problemId);
}
