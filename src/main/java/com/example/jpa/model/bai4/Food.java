package com.example.jpa.model.bai4;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.lang.reflect.Type;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 20,message = "Name cannot be longer than 20 characters")
    private String name;
    private int price;
    private String introduce;
    private String making;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeFood_id")
    @JsonBackReference
    private TypeFood typeFood;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "food")
    @JsonManagedReference
    private List<Recipe> recipes;
}
