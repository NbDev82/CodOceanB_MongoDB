package com.example.codoceanbmongo.discuss.service;

import com.example.codoceanbmongo.admin.category.request.AddCategoryRequest;
import com.example.codoceanbmongo.discuss.dto.CategoryDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO add(AddCategoryRequest request);

    void deleteCategory(UUID id);
}
