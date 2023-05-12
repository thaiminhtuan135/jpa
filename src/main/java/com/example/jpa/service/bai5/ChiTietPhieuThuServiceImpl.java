package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.ChiTietPhieuThu;
import com.example.jpa.repository.bai5.ChiTieuPhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietPhieuThuServiceImpl implements ChiTietPhieuThuService{
    @Autowired
    private ChiTieuPhieuThuRepository chiTieuPhieuThuRepository;

    @Override
    public ChiTietPhieuThu save(ChiTietPhieuThu chiTietPhieuThu) {
        return chiTieuPhieuThuRepository.save(chiTietPhieuThu);
    }

    @Override
    public Optional<ChiTietPhieuThu> getChiTietPhieuThuById(int id) {
        return chiTieuPhieuThuRepository.findById(id);
    }

    @Override
    public List<ChiTietPhieuThu> chiTietPhieuThus() {
        return chiTieuPhieuThuRepository.findAll();
    }

}
