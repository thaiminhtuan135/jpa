package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.TypeFood;

import java.util.Optional;

public interface TypeFoodService {
    Optional<TypeFood> getTypeFoodById(int id);

    void delete(int id);
}
