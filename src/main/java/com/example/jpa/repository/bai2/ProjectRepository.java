package com.example.jpa.repository.bai2;

import com.example.jpa.model.bai2.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
}
