package com.company.inventory.response;

import com.company.inventory.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryResponse extends ResponseRest {
    private List<Category> categories;
}
