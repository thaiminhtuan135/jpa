package com.example.jpa.repository.bai5;

import com.example.jpa.model.bai5.LoaiNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiNguyenLieuRepository extends JpaRepository<LoaiNguyenLieu, Integer>{
}
