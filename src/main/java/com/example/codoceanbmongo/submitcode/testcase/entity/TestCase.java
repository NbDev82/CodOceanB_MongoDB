package com.example.codoceanbmongo.submitcode.testcase.entity;

import com.example.codoceanbmongo.submitcode.parameter.entity.Parameter;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Document(collection = "test_cases")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TestCase implements Serializable {
    @Id
    private UUID id;

    private String outputData;

    private boolean isPublic = false;

    @DBRef
    private Problem problem;

    @DBRef
    private List<Parameter> parameters;
}
