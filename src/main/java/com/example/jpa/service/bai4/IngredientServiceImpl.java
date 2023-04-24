package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.Ingredient;
import com.example.jpa.repository.bai4.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService{
    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public Optional<Ingredient> getIngredientById(int id) {
        return ingredientRepository.findById(id);
    }
}
