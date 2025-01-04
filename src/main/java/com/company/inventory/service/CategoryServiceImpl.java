package com.company.inventory.service;

import com.company.inventory.exception.ResourceNotFoundException;
import com.company.inventory.model.Category;
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
}
