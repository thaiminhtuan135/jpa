package com.example.jpa.service;

import com.example.jpa.model.Classes;
import com.example.jpa.model.Student;

import java.util.List;
import java.util.Optional;

public interface ClassesService {
    Optional<Classes> getByid(Integer id);

    List<Student> getAllStudentOfClass(int id);
}
