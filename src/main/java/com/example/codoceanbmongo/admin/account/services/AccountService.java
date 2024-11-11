package com.example.codoceanbmongo.admin.account.services;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.profile.dto.ProfileDTO;

import java.util.List;

public interface AccountService {
    boolean editRole(String email, User.ERole newRole);
    boolean lockUser(String email);
    boolean unlockAccount(String email);
    List<ProfileDTO> getProfiles();
    ProfileDTO getProfileByEmail(String email);
    ProfileDTO changeProfileByEmail(String email, ProfileDTO profileDTO);
}
