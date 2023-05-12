package com.example.jpa.model.bai5;

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
public class ChiTietPhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int soLuongBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguyenLieu_id")
    @JsonBackReference
    private NguyenLieu nguyenLieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieuThu_id")
    @JsonBackReference
    private PhieuThu phieuThu;
}
