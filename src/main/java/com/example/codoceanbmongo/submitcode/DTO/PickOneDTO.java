package com.example.codoceanbmongo.submitcode.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class PickOneDTO {
    private UUID id;
    private String title;
}
