package com.example.jpa.service;

import com.example.jpa.model.Classes;
import com.example.jpa.model.Student;
import com.example.jpa.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository classesRepository;


    @Override
    public Optional<Classes> getByid(Integer id) {
        return classesRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudentOfClass(int id) {
        Classes classes = classesRepository.findById(id).get();
        return classes.getStudentList();
    }
}
