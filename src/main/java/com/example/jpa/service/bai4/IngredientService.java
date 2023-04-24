package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.Ingredient;

import java.util.Optional;

public interface IngredientService {
    Optional<Ingredient> getIngredientById(int id);
}
