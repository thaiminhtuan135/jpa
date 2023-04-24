package com.example.jpa.controller.bai4;

import com.example.jpa.model.bai4.Food;
import com.example.jpa.model.bai4.Ingredient;
import com.example.jpa.model.bai4.Recipe;
import com.example.jpa.service.bai4.FoodService;
import com.example.jpa.service.bai4.IngredientService;
import com.example.jpa.service.bai4.RecipeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/create/food/{foodId}/ingredient/{ingredientId}")
    public ResponseEntity<Recipe> createRecipe(@RequestBody String recipe,
                                               @PathVariable Integer foodId,
                                               @PathVariable Integer ingredientId) {
        Gson gson = new Gson();
        try {
            Food food = foodService.getFoodById(foodId).get();
            Ingredient ingredient1 = ingredientService.getIngredientById(ingredientId).get();
            Recipe recipe1 = gson.fromJson(recipe, Recipe.class);
            recipe1.setFood(food);
            recipe1.setIngredient(ingredient1);
            recipeService.save(recipe1);

            food.setMaking(food.getMaking()+" ,"+ingredient1.getName()+" :"+ recipe1.getAmount()+" "+ recipe1.getUnit());
            foodService.save(food);

            return new ResponseEntity<>(recipe1, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
