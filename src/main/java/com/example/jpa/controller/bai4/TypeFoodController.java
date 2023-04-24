package com.example.jpa.controller.bai4;


import com.example.jpa.model.Student;
import com.example.jpa.model.bai4.TypeFood;
import com.example.jpa.service.bai4.TypeFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/typeFood")
public class TypeFoodController {

    @Autowired
    private TypeFoodService typeFoodService;

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeFood> delete(@PathVariable Integer id) {
        try {
            TypeFood typeFood = typeFoodService.getTypeFoodById(id).get();
            typeFoodService.delete(id);
            return new ResponseEntity<TypeFood>(typeFood, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<TypeFood>(HttpStatus.NOT_FOUND);
        }
    }

}
