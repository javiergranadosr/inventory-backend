package com.company.inventory.controller;

import com.company.inventory.response.CategoryResponse;
import com.company.inventory.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/inventory")
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

}
