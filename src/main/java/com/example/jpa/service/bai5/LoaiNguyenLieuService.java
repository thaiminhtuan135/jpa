package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.LoaiNguyenLieu;

import java.util.Optional;

public interface LoaiNguyenLieuService {
    Optional<LoaiNguyenLieu> getLoaiNguyenLieuById(int id);
}
