package com.example.jpa.service.bai2;

import com.example.jpa.model.bai2.Project_Employee;
import com.example.jpa.repository.bai2.ProjectEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProjectEmployeeImpl implements ProjectEmployeeService {

    @Autowired
    private ProjectEmployeeRepository repository;


    @Override
    public Optional<Project_Employee> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Project_Employee save(Project_Employee project_employee) {
        return repository.save(project_employee);
    }

    @Override
    public List<Project_Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Map<Integer,Double> getWorkhour() {
        return repository.getWorkHour();
    }
}
