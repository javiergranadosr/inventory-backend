package com.company.inventory.service;

import com.company.inventory.exception.ResourceNotFoundException;
import com.company.inventory.model.Category;
import com.company.inventory.dto.CategoryDTO;
import com.company.inventory.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService{
    private final ICategoryRepository categoryRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        log.info("Call method getAllCategories()");
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCatgoryById(Long id) {
        log.info("Call method getCategoryById()");
        Optional<Category> data = this.categoryRepository.findById(id);
        if (data.isEmpty()) {
            log.warn("Data empty");
            throw new ResourceNotFoundException("Category not found");
        }
        return data.get();
    }

    @Override
    @Transactional
    public Category createCategory(CategoryDTO data) {
        log.info("Call method createCategory()");
        Category tempData = new Category();
        tempData.setName(data.getName());
        tempData.setDescription(data.getDescription());
        return this.categoryRepository.save(tempData);
    }

    @Override
    @Transactional
    public Category updateCategory(Long id, CategoryDTO data) {
        log.info("Call method updateCategory()");
        Optional<Category> tempData = this.categoryRepository.findById(id);
        if (tempData.isEmpty()) {
            throw new ResourceNotFoundException("Category not found");
        }
        tempData.get().setName(data.getName());
        tempData.get().setDescription(data.getDescription());
        return this.categoryRepository.save(tempData.get());
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        log.info("Call method deleteCategory()");
        Optional<Category> tempData = this.categoryRepository.findById(id);
        if (tempData.isEmpty()) {
            throw new ResourceNotFoundException("Category not found");
        }
        this.categoryRepository.deleteById(id);
    }
}
