package com.example.jpa.model.bai2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Project_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "project_id", insertable = false, updatable = false)
    private int project_id;
    @Column(name = "employee_id", insertable = false, updatable = false)
    private int employee_id;
    @Positive
    private int work_hour;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

}
