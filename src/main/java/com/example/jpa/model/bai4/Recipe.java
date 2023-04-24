package com.example.jpa.model.bai4;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int amount;
    @Size(max = 10,message = "Unit cannot be longer than 10 characters")
    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    @JsonBackReference
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    @JsonBackReference
    private Ingredient ingredient;

}
