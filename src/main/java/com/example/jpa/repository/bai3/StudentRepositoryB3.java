package com.example.jpa.repository.bai3;

import com.example.jpa.model.bai3.StudentB3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryB3 extends JpaRepository<StudentB3, Integer>{
}
