package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 10, message = "Class name cannot be longer than 10 characters")
    private String name;
    private int number;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "classes")
    @JsonManagedReference
    private List<Student> studentList = new ArrayList<>();

}
