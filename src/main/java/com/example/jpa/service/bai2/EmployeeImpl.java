package com.example.jpa.service.bai2;

import com.example.jpa.model.bai2.Employee;
import com.example.jpa.repository.bai2.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

}
