package com.example.jpa.DTO;

import lombok.*;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class SalaryEmployeeDTO {
    private int id;
    private String name;
    private String telephone;
    private String address;
    private String email;
    private Double totalSalary;
}
