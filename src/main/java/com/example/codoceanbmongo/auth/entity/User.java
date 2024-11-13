package com.example.codoceanbmongo.auth.entity;

import com.example.codoceanbmongo.comment.entity.Comment;
import com.example.codoceanbmongo.contest.entity.Contest;
import com.example.codoceanbmongo.contest.entity.ContestEnrollment;
import com.example.codoceanbmongo.discuss.entity.Emoji;
import com.example.codoceanbmongo.notification.entity.Notification;
import com.example.codoceanbmongo.payment.entity.Payment;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import com.example.codoceanbmongo.submitcode.submission.entity.Submission;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User implements UserDetails {
    @Id
    private UUID id;

    private String fullName;
    private String phoneNumber;
    private LocalDateTime dateOfBirth;
    private String email;
    private String urlImage;
    private String password;
    private String address;
    private String city;
    private String country;
    private String school;
    private String occupation;
    private String favoriteProgrammingLanguage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime VIPExpDate;
    private boolean isActive;
    private boolean isFirstLogin;
    private ERole role;
    private boolean isLocked;

    @DBRef
    private List<Problem> ownedProblems;

    @DBRef
    private List<ContestEnrollment> contestEnrollments;

    @DBRef
    private List<Contest> contests;

    @DBRef
    private Token token;

    @DBRef
    private List<Notification> notifications;

    @DBRef
    private List<Comment> comments;

    @DBRef
    private List<Submission> submissions;

    @DBRef
    private List<OTP> otps;

    @DBRef
    private List<Payment> payments;

    @DBRef
    private List<Emoji> emojis;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.name().toUpperCase()));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return fullName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public enum ERole {
        USER(0),
        USER_VIP(1),
        ADMIN(2),
        MODERATOR(3);

        private final int value;

        ERole(int value) {
            this.value = value;
        }
    }
}
