package com.example.jpa.repository.bai4;

import com.example.jpa.model.bai4.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{
}
