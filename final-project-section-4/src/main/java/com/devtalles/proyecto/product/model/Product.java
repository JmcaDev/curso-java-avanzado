package com.devtalles.proyecto.product.model;

import com.devtalles.proyecto.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
    private int stock;
    private Category category;
}
