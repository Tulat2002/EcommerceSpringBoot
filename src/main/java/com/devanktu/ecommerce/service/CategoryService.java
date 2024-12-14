package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.CategoryDto;
import com.devanktu.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);

    List<Category> getAllCategories();

}
