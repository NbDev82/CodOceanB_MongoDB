package com.example.codoceanbmongo.discuss.service;

import com.example.codoceanbmongo.admin.category.request.AddCategoryRequest;
import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.discuss.dto.CategoryDTO;
import com.example.codoceanbmongo.discuss.entity.Category;
import com.example.codoceanbmongo.discuss.repository.CategoryRepository;
import com.example.codoceanbmongo.uploadfile.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return convertToCategoryDTOs(categories);
    }

    @Override
    public CategoryDTO add(AddCategoryRequest request) {
        String imgUrl = uploadFileService.uploadImage(request.getImage(), User.ERole.ADMIN.name());

        Category category = Category.builder()
                .name(request.getName())
                .imageUrl(imgUrl)
                .description(request.getDescription())
                .build();
        categoryRepository.save(category);
        return convertToCategoryDTO(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDTO convertToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .imageUrl(category.getImageUrl())
                .build();
    }

    private List<CategoryDTO> convertToCategoryDTOs(List<Category> categories) {
        return categories.stream()
                         .map(this::convertToCategoryDTO)
                         .toList();
    }
}
