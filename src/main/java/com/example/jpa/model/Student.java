package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 20,message = "Name cannot be longer than 20 characters")
    @Pattern(regexp = "^(\\S+\\s{1}\\S+)+$", message = "Name must contain at least 2 words")
    private String name;
    @Min(value = 2002, message = "Year of birth must be greater than or equal to 2002")
    @Max(value = 2014, message = "Year of birth must be less than or equal to 2014")
    private int year_of_birth;
    private String address;
//    @Nullable
//    @Column(name = "classes_id", insertable = false, updatable = false)
//    private int classes_id;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "classes_id")
    @JsonBackReference
    private Classes classes;
}
