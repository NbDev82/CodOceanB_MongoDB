package com.example.codoceanbmongo.submitcode.library.repository;

import com.example.codoceanbmongo.submitcode.library.entity.LibrariesSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends MongoRepository<LibrariesSupport, UUID> {
}