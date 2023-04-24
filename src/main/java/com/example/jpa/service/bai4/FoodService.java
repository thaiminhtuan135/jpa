package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Food save(Food food);

    Optional<Food> getFoodById(int id);

    List<Food> listFood();
}
