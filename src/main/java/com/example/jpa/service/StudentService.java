package com.example.jpa.service;

import com.example.jpa.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudent();

    Student get(Integer id);

    public void delete(Integer id);

    public List<Student> searchUser(String keyword);

    void addListStudent();
}
