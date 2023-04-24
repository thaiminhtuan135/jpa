package com.example.jpa.service.bai2;

import com.example.jpa.model.bai2.Employee;
import com.example.jpa.model.bai2.Project_Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProjectEmployeeService {
    Optional<Project_Employee> getById(int id);

    Project_Employee save(Project_Employee project_employee);

    List<Project_Employee> getAll();

    Map<Integer,Double> getWorkhour();
}
