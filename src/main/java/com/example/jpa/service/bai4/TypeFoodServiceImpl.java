package com.example.jpa.service.bai4;

import com.example.jpa.model.bai4.TypeFood;
import com.example.jpa.repository.bai4.TypeFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeFoodServiceImpl implements TypeFoodService{
    @Autowired
    private TypeFoodRepository typeFoodRepository;
    @Override
    public Optional<TypeFood> getTypeFoodById(int id) {
        return typeFoodRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        typeFoodRepository.deleteById(id);
    }
}
