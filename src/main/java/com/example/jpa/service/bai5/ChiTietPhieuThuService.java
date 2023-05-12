package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.ChiTietPhieuThu;

import java.util.List;
import java.util.Optional;

public interface ChiTietPhieuThuService {

    ChiTietPhieuThu save(ChiTietPhieuThu chiTietPhieuThu);
    Optional<ChiTietPhieuThu> getChiTietPhieuThuById(int id);

    List<ChiTietPhieuThu> chiTietPhieuThus();
}
