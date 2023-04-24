package com.example.jpa.model.bai2;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 10,message = "Project name cannot be longer than 10 characters")
    private String name;
    private String description;
    private String note;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY,mappedBy = "project")
    @JsonManagedReference
    private List<Project_Employee> projectEmployees;
}
