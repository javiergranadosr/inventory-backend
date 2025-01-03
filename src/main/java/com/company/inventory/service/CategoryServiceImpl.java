package com.company.inventory.service;

import com.company.inventory.repository.ICategoryRepository;
import com.company.inventory.response.CategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService{
    private final ICategoryRepository categoryRepository;
    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getAllCategories() {
        CategoryResponse response = new CategoryResponse();
        response.setCategories(this.categoryRepository.findAll());
        response.setMetadata("OK", "200", "Respuesta exitosa");
        return response;
    }
}
