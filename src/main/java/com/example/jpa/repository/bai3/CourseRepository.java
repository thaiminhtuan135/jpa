package com.example.jpa.repository.bai3;

import com.example.jpa.model.bai3.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
}
