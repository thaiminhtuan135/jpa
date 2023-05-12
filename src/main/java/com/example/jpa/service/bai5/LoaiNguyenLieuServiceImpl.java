package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.LoaiNguyenLieu;
import com.example.jpa.repository.bai5.LoaiNguyenLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiNguyenLieuServiceImpl implements LoaiNguyenLieuService{
    @Autowired
    private LoaiNguyenLieuRepository loaiNguyenLieuRepository;
    @Override
    public Optional<LoaiNguyenLieu> getLoaiNguyenLieuById(int id) {
        return loaiNguyenLieuRepository.findById(id);
    }
}
