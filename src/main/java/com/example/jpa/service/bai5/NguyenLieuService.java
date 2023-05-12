package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.NguyenLieu;

import java.util.Optional;

public interface NguyenLieuService {
    NguyenLieu save(NguyenLieu nguyenLieu);

    Optional<NguyenLieu> getNguyenLieuById(int id);
}
