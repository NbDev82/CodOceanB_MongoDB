package com.example.codoceanbmongo.admin.category.controller;

import com.example.codoceanbmongo.admin.category.request.AddCategoryRequest;
import com.example.codoceanbmongo.discuss.dto.CategoryDTO;
import com.example.codoceanbmongo.discuss.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/v1/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@ModelAttribute AddCategoryRequest request) {
        return ResponseEntity.ok(categoryService.add(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
