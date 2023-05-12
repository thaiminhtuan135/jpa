package com.example.jpa.model.bai5;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class PhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate ngayLap;
    private String nhanVienLap;
    private String ghiChu;
    private int thanhTien;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "phieuThu")
    @JsonManagedReference
    private List<ChiTietPhieuThu> chiTietPhieuThus;

}
