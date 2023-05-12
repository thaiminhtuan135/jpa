package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.NguyenLieu;
import com.example.jpa.repository.bai5.NguyenLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NguyenLieuServiceImpl implements NguyenLieuService{
    @Autowired
    private NguyenLieuRepository nguyenLieuRepository;
    @Override
    public NguyenLieu save(NguyenLieu nguyenLieu) {
        return nguyenLieuRepository.save(nguyenLieu);
    }

    @Override
    public Optional<NguyenLieu> getNguyenLieuById(int id) {
        return nguyenLieuRepository.findById(id);
    }
}
