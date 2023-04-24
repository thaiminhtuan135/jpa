package com.example.jpa.service.bai2;

import com.example.jpa.model.bai2.Employee;

import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> getEmployeeById(int id);

    void delete(Integer id);

}
