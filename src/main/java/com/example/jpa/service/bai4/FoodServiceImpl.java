package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.Food;
import com.example.jpa.repository.bai4.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodRepository foodRepository;
    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Optional<Food> getFoodById(int id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> listFood() {
        return foodRepository.findAll();
    }
}
