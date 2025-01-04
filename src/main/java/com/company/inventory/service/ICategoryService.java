package com.company.inventory.service;

import com.company.inventory.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();
    Category getCatgoryById(Long id);

}
