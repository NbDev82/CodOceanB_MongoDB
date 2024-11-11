package com.example.codoceanbmongo.profile.controller;

import com.example.codoceanbmongo.auth.service.UserService;
import com.example.codoceanbmongo.discuss.dto.DiscussDTO;
import com.example.codoceanbmongo.discuss.service.DiscussService;
import com.example.codoceanbmongo.profile.dto.ProfileDTO;
import com.example.codoceanbmongo.profile.request.ChangeEmailRequest;
import com.example.codoceanbmongo.profile.response.ProfileResponse;
import com.example.codoceanbmongo.submitcode.DTO.ProblemDTO;
import com.example.codoceanbmongo.submitcode.problem.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {
    private static final Logger log = LogManager.getLogger(ProfileController.class);

    private final UserService userService;
    private final ProblemService problemService;
    private final DiscussService discussService;

    @GetMapping("/get-profile")
    public ResponseEntity<ProfileResponse> extractProfile(@RequestHeader(value = "Authorization") String authHeader) {
        ProfileResponse profileResponse = userService.getProfile(authHeader);
        return ResponseEntity.ok(profileResponse);
    }

    @PostMapping("/change-profile")
    public ResponseEntity<ProfileResponse> changeProfile(@RequestBody ProfileDTO profileDTO,
                                                         @RequestHeader(value = "Authorization") String authHeader) {
        return ResponseEntity.ok(userService.changeProfile(authHeader, profileDTO));
    }

//    @GetMapping("/collect-user-info")
//    public ResponseEntity<ProfileDTO> collectUserInfo(@RequestHeader(value = "Authorization") String authHeader) {
//        ProfileDTO profileDTO = userService.collectUserInfo(authHeader);
//        return ResponseEntity.ok(profileDTO);
//    }

    @PostMapping("/change-email")
    public ResponseEntity<ProfileResponse> changeEmail(@RequestBody ChangeEmailRequest request,
                                                       @RequestHeader(value = "Authorization") String authHeader) {
        ProfileResponse profileResponse = userService.changeEmail(authHeader, request.getOtp(), request.getNewEmail());
        return ResponseEntity.ok(profileResponse);
    }

    @PostMapping("/change-avatar")
    public ResponseEntity<String> changeAvatar(@RequestBody MultipartFile file,
                                               @RequestHeader(value = "Authorization") String authHeader) {
        String imgUrl = userService.changeAvatar(authHeader, file);
        return ResponseEntity.ok(imgUrl);
    }

    @GetMapping("/get-all-uploaded-problems")
    public ResponseEntity<List<ProblemDTO>> getProblemsByOwner(@RequestHeader(value = "Authorization") String authHeader) {
        log.info("Fetching problems by token: {}", authHeader);
        return ResponseEntity.ok(problemService.getAllUploadedProblemsByUser(authHeader));
    }

    @GetMapping("/get-all-solved-problems")
    public ResponseEntity<List<ProblemDTO>> getAllSolvedProblems(@RequestHeader(value = "Authorization") String authHeader) {
        log.info("Fetching all solved problems by token: {}", authHeader);
        return ResponseEntity.ok(problemService.getAllSolvedProblemsByUser(authHeader));
    }

    @GetMapping("/get-all-uploaded-discusses")
    public ResponseEntity<List<DiscussDTO>> getAllUploadedDiscusses(@RequestHeader(value = "Authorization") String authHeader) {
        log.info("Fetching all uploaded discusses by token: {}", authHeader);
        return ResponseEntity.ok(discussService.getAllUploadedDiscussesByUser(authHeader));
    }
}
