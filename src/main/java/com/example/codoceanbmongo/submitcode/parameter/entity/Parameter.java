package com.example.codoceanbmongo.submitcode.parameter.entity;

import com.example.codoceanbmongo.submitcode.testcase.entity.TestCase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document(collection = "parameters")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Parameter implements Serializable {
    @Id
    private UUID id;

    private int index;

    private String name;

    private String inputDataType;

    private String inputData;

    @DBRef
    private TestCase testCase;
}
