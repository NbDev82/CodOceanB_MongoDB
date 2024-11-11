package com.example.codoceanbmongo.submitcode.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ParameterDTO {
    private String name;
    private String inputDataType;
    private String inputData;
}
