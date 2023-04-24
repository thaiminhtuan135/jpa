package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.Recipe;
import com.example.jpa.repository.bai4.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
