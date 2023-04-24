package com.example.jpa.model.bai2;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 20,message = "Name cannot be longer than 20 characters")
    @Pattern(regexp = "^(\\S+\\s{1}\\S+)+$", message = "Name must contain at least 2 words")
    private String name;
    private String telephone;

    private String address;
    private String email;
    private Double coefficient_salary;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "employee")
    @JsonManagedReference
    private List<Project_Employee> projectEmployees;
}
