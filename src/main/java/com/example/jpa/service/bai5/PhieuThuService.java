package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.PhieuThu;

import java.util.List;
import java.util.Optional;

public interface PhieuThuService {
    void delete(int id);

    List<PhieuThu> phieuThuList();
    PhieuThu save(PhieuThu phieuThu);
    Optional<PhieuThu> getPhieuThuById(int id);
}
