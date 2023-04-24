package com.example.jpa.controller.bai2;

import com.example.jpa.DTO.SalaryEmployeeDTO;
import com.example.jpa.model.Student;
import com.example.jpa.model.bai2.Employee;
import com.example.jpa.model.bai2.Project;
import com.example.jpa.model.bai2.Project_Employee;
import com.example.jpa.service.bai2.EmployeeService;
import com.example.jpa.service.bai2.ProjectEmployeeService;
import com.example.jpa.service.bai2.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private ProjectEmployeeService projectEmployeeService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        try {
            Employee employee = employeeService.getEmployeeById(id).get();
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/work-hour/employee/{employeeId}/project/{projectId}")
    public ResponseEntity<Project_Employee> addWorkHourForEmployee(
            @PathVariable Integer employeeId,
            @PathVariable Integer projectId , @RequestParam int workHour) {
        try {
            Employee employee = employeeService.getEmployeeById(employeeId).get();
            Project project = projectService.getProjectById(projectId).get();
            Project_Employee project_employee = new Project_Employee();
            project_employee.setEmployee(employee);
            project_employee.setProject(project);
            project_employee.setEmployee_id(employeeId);
            project_employee.setProject_id(projectId);
            project_employee.setWork_hour(workHour);
            projectEmployeeService.save(project_employee);
            return new ResponseEntity<Project_Employee>(project_employee, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        try {
            Employee employee = employeeService.getEmployeeById(id).get();
            employeeService.delete(id);
            return new ResponseEntity<Employee>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/work-hour")
    public List<SalaryEmployeeDTO> getWorkHour() {
        List<SalaryEmployeeDTO> salaryEmployeeDTOList = new ArrayList<>();

        Map<Integer, List<Integer>> map = projectEmployeeService.getAll().stream()
                .collect(Collectors.groupingBy(Project_Employee::getEmployee_id,
                        Collectors.mapping(Project_Employee::getWork_hour, Collectors.toList())));

//        Map<Employee, Double> workHour = new HashMap<>();

        map.forEach((id, integers) -> {
            Employee employee = employeeService.getEmployeeById(id).get();
            double sum = integers.stream()
                    .mapToInt(Integer::intValue)
                    .sum() * 15 * employee.getCoefficient_salary();
//            workHour.put(employee, sum);

            salaryEmployeeDTOList.add(SalaryEmployeeDTO
                    .builder()
                    .id(employee.getId()).name(employee.getName())
                    .telephone(employee.getTelephone())
                    .email(employee.getEmail()).totalSalary(sum).build()
            );

        });
        return salaryEmployeeDTOList;
    }

    @GetMapping("/getWorkHour")
    public ResponseEntity<?> getWorkhour() {
        return new ResponseEntity<>(projectEmployeeService.getWorkhour(),HttpStatus.OK);
    }
}
