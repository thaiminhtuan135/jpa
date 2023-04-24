package com.example.jpa.service.bai3;

import com.example.jpa.model.bai3.StudentB3;

import java.util.List;
import java.util.Optional;

public interface StudentServiceB3 {
    Optional<StudentB3> getStudentById(int id);

    StudentB3 save(StudentB3 studentB3);

    List<StudentB3> getStudents();
}
