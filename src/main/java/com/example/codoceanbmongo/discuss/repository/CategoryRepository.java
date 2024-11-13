package com.example.codoceanbmongo.discuss.repository;

import com.example.codoceanbmongo.discuss.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends MongoRepository<Category, UUID> {
    List<Category> findByNameIn(List<String> names);

    Category findByName(String name);
}