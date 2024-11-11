package com.example.codoceanbmongo.discuss.request;

import com.example.codoceanbmongo.discuss.dto.CategoryDTO;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddDiscussRequest {
    private String title;
    private String description;
    private List<CategoryDTO> categories;
    private LocalDateTime endAt;
    private List<MultipartFile> multipartFiles;
}
