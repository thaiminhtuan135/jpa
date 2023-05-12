package com.example.jpa.repository.bai5;

import com.example.jpa.model.bai5.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuThuRepository extends JpaRepository<PhieuThu, Integer>{
}
