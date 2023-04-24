package com.example.jpa.model.bai3;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class DayStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daystudy_id")
    @JsonBackReference
    private Course course;
}
