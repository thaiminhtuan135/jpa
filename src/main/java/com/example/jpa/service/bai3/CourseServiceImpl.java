package com.example.jpa.service.bai3;

import com.example.jpa.model.bai3.Course;
import com.example.jpa.repository.bai3.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
