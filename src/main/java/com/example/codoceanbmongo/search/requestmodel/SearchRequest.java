package com.example.codoceanbmongo.search.requestmodel;

import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SearchRequest {
    private int pageNumber;
    private int limit;
    private EStatus status;
    private Problem.EDifficulty difficulty;
    private Problem.ETopic topic;
    private String searchTerm;

    public enum EStatus {
        SOLVED,
        ATTEMPTED,
        TODO
    }
}
