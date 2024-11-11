package com.example.codoceanbmongo.admin.category.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCategoryRequest {
    private String name;
    private String description;
    private MultipartFile image;
}
