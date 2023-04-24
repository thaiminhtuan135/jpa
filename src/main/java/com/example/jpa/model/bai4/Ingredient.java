package com.example.jpa.model.bai4;

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
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 20,message = "Name cannot be longer than 20 characters")
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ingredient")
    @JsonManagedReference
    private List<Recipe> recipes;
}
