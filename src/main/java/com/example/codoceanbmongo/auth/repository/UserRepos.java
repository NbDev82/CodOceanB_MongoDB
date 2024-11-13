package com.example.codoceanbmongo.auth.repository;

import com.example.codoceanbmongo.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepos extends MongoRepository<User, UUID> {
    boolean existsByPhoneNumberOrEmail(String phoneNumber, String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    // Find all users where role is not 'ADMIN'
    @Query("{ 'role': { $ne: ?0 } }")
    List<User> findUsersByRoleNot(String role);

//    List<Map<String, Object>> getTotalMonthlyUsersCountByYear(int year);
//
//    // Get the count of new users for each month of the given year
//    List<Map<String, Object>> getMonthlyNewUsersCountByYear(int year);
}