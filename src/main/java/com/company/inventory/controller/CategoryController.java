package com.company.inventory.controller;

import com.company.inventory.dto.CategoryDTO;
import com.company.inventory.model.Category;
import com.company.inventory.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/inventory")
@Tag(name = "CategoryController", description = "API categorías")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Obtener listado de categorías",
            description = "Obtiene listado de categorías",
            method = "GET"
    )
    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @Operation(
            summary = "Obtener categoría por id",
            description = "Obtiene categoría por id",
            method = "GET"
    )
    @GetMapping(value = "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.getCatgoryById(id));
    }

    @Operation(
            summary = "Crear categoría",
            description = "Crea categoría",
            method = "POST"
    )
    @PostMapping(value = "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO data) {
        return new ResponseEntity<>(this.categoryService.createCategory(data), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Actualizar categoría",
            description = "Actualiza categoría",
            method = "PUT"
    )
    @PutMapping(value = "/categories/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO data) {
        return new ResponseEntity<>(this.categoryService.updateCategory(id, data), HttpStatus.OK);
    }

    @Operation(
            summary = "Eliminar categoría",
            description = "Elimina categoría",
            method = "DELETE"
    )
    @DeleteMapping(value = "/categories/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
