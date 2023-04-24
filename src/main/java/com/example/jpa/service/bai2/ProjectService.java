package com.example.jpa.service.bai2;

import com.example.jpa.model.bai2.Project;

import java.util.Optional;

public interface ProjectService {
    Optional<Project> getProjectById(int id);

    Project save(Project project);
}
