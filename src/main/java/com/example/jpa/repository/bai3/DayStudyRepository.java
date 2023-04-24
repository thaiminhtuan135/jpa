package com.example.jpa.repository.bai3;

import com.example.jpa.model.bai3.Course;
import com.example.jpa.model.bai3.DayStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayStudyRepository extends JpaRepository<DayStudy, Integer>{
}
