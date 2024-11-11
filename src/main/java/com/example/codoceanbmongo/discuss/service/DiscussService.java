package com.example.codoceanbmongo.discuss.service;

import com.example.codoceanbmongo.discuss.dto.DiscussDTO;
import com.example.codoceanbmongo.discuss.entity.Discuss;
import com.example.codoceanbmongo.discuss.request.AddDiscussRequest;
import com.example.codoceanbmongo.discuss.request.UpdateDiscussRequest;

import java.util.List;
import java.util.UUID;

public interface DiscussService {
    List<DiscussDTO> getAllUploadedDiscussesByUser(String token);

    List<DiscussDTO> getDiscusses(String authHeader,
                                  int pageNumber,
                                  int limit,
                                  String searchTerm,
                                  String category);
    DiscussDTO getDiscussById(UUID id, String authHeader);
    Discuss getDiscuss(UUID id);
    DiscussDTO addDiscuss(AddDiscussRequest request, String authHeader);

    DiscussDTO updateDiscuss(UUID id, UpdateDiscussRequest request);
    void deleteDiscuss(UUID id);


}
