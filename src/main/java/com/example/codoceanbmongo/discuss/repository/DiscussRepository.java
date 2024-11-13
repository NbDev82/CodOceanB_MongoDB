package com.example.codoceanbmongo.discuss.repository;

import com.example.codoceanbmongo.discuss.entity.Discuss;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface DiscussRepository extends MongoRepository<Discuss, UUID> {
    List<Discuss> findByIsClosedFalseAndOwnerEmail(String email);

    Page<Discuss> findByTitleContainsIgnoreCaseAndCategoriesName(String searchTerm, String category, Pageable pageable);

    List<Discuss> findByCreatedAtYear(int year); // Requires custom aggregation for advanced date extraction

    @Aggregation(pipeline = {
            "{ $match: { title: { $regex: ?0, $options: 'i' }, 'categories.name': ?1 } }",
            "{ $addFields: { comment_count: { $size: { $ifNull: ['$comments', []] } } } }",
            "{ $sort: { comment_count: -1 } }",
            "{ $skip: ?2 }",  // Skip for pagination
            "{ $limit: ?3 }"  // Limit for pagination
    })
    Slice<Discuss> findAllWithCommentCount(String searchTerm, String category, int skip, int limit);

    @Aggregation(pipeline = {
            "{ $match: { 'createdAt': { $gte: ISODate(?0), $lt: ISODate(?1) } } }",
            "{ $group: { _id: { $month: '$createdAt' }, total: { $count: {} } } }",
            "{ $sort: { '_id': 1 } }",
            "{ $project: { month: '$_id', total: 1, _id: 0 } }"
    })
    List<Map<String, Object>> getMonthlyPostsCount(String startOfYear, String endOfYear);
}
