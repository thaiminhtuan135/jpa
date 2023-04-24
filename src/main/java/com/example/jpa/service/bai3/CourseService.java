package com.example.jpa.service.bai3;

import com.example.jpa.model.bai3.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> getCourseById(int id);

    void delete(Integer id);

    List<Course> getCourses();
}
