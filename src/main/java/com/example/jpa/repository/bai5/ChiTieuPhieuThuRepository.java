package com.example.jpa.repository.bai5;

import com.example.jpa.model.bai5.ChiTietPhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTieuPhieuThuRepository extends JpaRepository<ChiTietPhieuThu, Integer>{
}
