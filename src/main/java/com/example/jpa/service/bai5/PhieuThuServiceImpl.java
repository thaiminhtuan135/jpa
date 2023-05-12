package com.example.jpa.service.bai5;

import com.example.jpa.model.bai5.PhieuThu;
import com.example.jpa.repository.bai5.PhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuThuServiceImpl implements  PhieuThuService{
    @Autowired
    private PhieuThuRepository phieuThuRepository;
    @Override
    public void delete(int id) {
        phieuThuRepository.deleteById(id);
    }

    @Override
    public List<PhieuThu> phieuThuList() {
        return phieuThuRepository.findAll();
    }

    @Override
    public PhieuThu save(PhieuThu phieuThu) {
        return phieuThuRepository.save(phieuThu);
    }

    @Override
    public Optional<PhieuThu> getPhieuThuById(int id) {
        return phieuThuRepository.findById(id);
    }
}
