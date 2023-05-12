package com.example.jpa.model.bai5;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenNguyenLieu;
    private int giaBan;
    private String donViTinh;
    private int soLuongKho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaiNguyenLieu_id")
    @JsonBackReference
    private LoaiNguyenLieu loaiNguyenLieu;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "nguyenLieu")
    @JsonManagedReference
    private List<ChiTietPhieuThu> chiTietPhieuThus;
}
