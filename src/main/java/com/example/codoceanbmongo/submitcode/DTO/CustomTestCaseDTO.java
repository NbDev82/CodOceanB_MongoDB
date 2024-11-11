package com.example.codoceanbmongo.submitcode.DTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomTestCaseDTO {
    List<ParameterDTO> parameterDTOs;
}
