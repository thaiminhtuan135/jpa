package com.example.jpa.repository.bai2;


import com.example.jpa.model.bai2.Project_Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<Project_Employee, Integer> {

    @Query(value = "SELECT e.id , SUM(e.coefficient_salary*pe.work_hour) FROM Employee e " +
            "JOIN Project_Employee pe ON e.id = pe.employee_id GROUP BY e.id",nativeQuery = true )
    Map<Integer,Double> getWorkHour();
}
