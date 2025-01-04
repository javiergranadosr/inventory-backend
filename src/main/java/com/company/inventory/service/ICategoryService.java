package com.company.inventory.service;

import com.company.inventory.model.Category;
import com.company.inventory.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();
    Category getCatgoryById(Long id);

    Category createCategory(CategoryDTO data);

    Category updateCategory(Long id, CategoryDTO data);
    void deleteCategory(Long id);

}
