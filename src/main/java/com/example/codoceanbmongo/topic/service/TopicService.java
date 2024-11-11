package com.example.codoceanbmongo.topic.service;

import com.example.codoceanbmongo.topic.dto.TopicDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    List<TopicDTO> getTopics();
}
