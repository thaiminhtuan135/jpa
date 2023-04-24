package com.example.jpa.service.bai3;

import com.example.jpa.model.bai3.StudentB3;
import com.example.jpa.repository.bai3.StudentRepositoryB3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplB3 implements StudentServiceB3 {
    @Autowired
    private StudentRepositoryB3 studentRepositoryB3;
    @Override
    public Optional<StudentB3> getStudentById(int id) {
        return studentRepositoryB3.findById(id);
    }

    @Override
    public StudentB3 save(StudentB3 studentB3) {
        return studentRepositoryB3.save(studentB3);
    }

    @Override
    public List<StudentB3> getStudents() {
        return studentRepositoryB3.findAll();
    }
}
