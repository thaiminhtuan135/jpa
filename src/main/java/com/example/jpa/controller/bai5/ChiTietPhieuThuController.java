package com.example.jpa.controller.bai5;


import com.example.jpa.model.bai5.ChiTietPhieuThu;
import com.example.jpa.model.bai5.NguyenLieu;
import com.example.jpa.model.bai5.PhieuThu;
import com.example.jpa.service.bai5.ChiTietPhieuThuService;
import com.example.jpa.service.bai5.NguyenLieuService;
import com.example.jpa.service.bai5.PhieuThuService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/chitietphieuthu")
public class ChiTietPhieuThuController {
    @Autowired
    private ChiTietPhieuThuService chiTietPhieuThuService;
    @Autowired
    private PhieuThuService phieuThuService;

    @Autowired
    private NguyenLieuService nguyenLieuService;

    @PostMapping("/tao/phieuthu/{phieuThuId}/nguyenlieu/{nguyenLieuId}")
    public ResponseEntity<ChiTietPhieuThu> taoNguyenLieu(@RequestBody String chiTietPhieuThu,
                                                    @PathVariable Integer phieuThuId,
                                                    @PathVariable Integer nguyenLieuId
    ) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public Object deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        try {
            NguyenLieu nguyenLieu = nguyenLieuService.getNguyenLieuById(nguyenLieuId).get();
            PhieuThu phieuThu = phieuThuService.getPhieuThuById(phieuThuId).get();

            ChiTietPhieuThu chiTietPhieuThu1 = gson.fromJson(chiTietPhieuThu, ChiTietPhieuThu.class);
            chiTietPhieuThu1.setNguyenLieu(nguyenLieu);
            chiTietPhieuThu1.setPhieuThu(phieuThu);

            nguyenLieu.setSoLuongKho(nguyenLieu.getSoLuongKho() - chiTietPhieuThu1.getSoLuongBan());
            nguyenLieuService.save(nguyenLieu);

            List<ChiTietPhieuThu> chiTietPhieuThus = chiTietPhieuThuService
                    .chiTietPhieuThus()
                    .stream().
                    filter(chiTietPhieuThu2 -> chiTietPhieuThu2.getPhieuThu().getId() == phieuThuId)
                    .toList();
            int total = chiTietPhieuThus.stream()
                    .mapToInt(value -> value.getSoLuongBan() * value.getNguyenLieu().getGiaBan())
                    .sum();

            phieuThu.setThanhTien(total);
            phieuThuService.save(phieuThu);
            chiTietPhieuThuService.save(chiTietPhieuThu1);
            return new ResponseEntity<>(chiTietPhieuThu1, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
