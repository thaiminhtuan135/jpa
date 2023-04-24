package com.example.jpa.controller.bai4;

import com.example.jpa.model.bai2.Employee;
import com.example.jpa.model.bai4.Food;
import com.example.jpa.service.bai4.FoodService;
import com.example.jpa.service.bai4.TypeFoodService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private TypeFoodService typeFoodService;

    @PostMapping("/create/type-food/{typeFoodId}")
    public ResponseEntity<Food> createFood(@RequestBody String food, @PathVariable Integer typeFoodId) {
        Gson gson = new Gson();
        return typeFoodService.getTypeFoodById(typeFoodId).map(typeFood -> {
            Food food1 = gson.fromJson(food, Food.class);
            food1.setTypeFood(typeFood);
            return new ResponseEntity<>(foodService.save(food1), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Integer id) {
        try {
            Food food = foodService.getFoodById(id).get();
            return new ResponseEntity<Food>(food, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-food-by-name")
    public List<Food> foodsByName(@RequestParam String foodName) {
        List<Food> result = foodService.listFood().stream().filter(food -> food.getName().contains(foodName)).toList();
        return result;
    }

    @GetMapping("/get-food-by-ingredient")
    public List<Food> foodsByIngredientName(@RequestParam String ingredientName) {
        List<Food> result = foodService.listFood()
                .stream()
                .filter(
                        food -> food.getRecipes()
                                .stream()
                                .anyMatch(recipe -> recipe.getIngredient().getName().contains(ingredientName))
                ).collect(Collectors.toList());
        return result;
    }
}
