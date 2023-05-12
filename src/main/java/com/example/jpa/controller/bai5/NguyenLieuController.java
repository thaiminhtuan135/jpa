package com.example.jpa.controller.bai5;

import com.example.jpa.model.bai5.NguyenLieu;
import com.example.jpa.service.bai5.LoaiNguyenLieuService;
import com.example.jpa.service.bai5.NguyenLieuService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/nguyenlieu")
public class NguyenLieuController {
    @Autowired
    private NguyenLieuService nguyenLieuService;
    @Autowired
    private LoaiNguyenLieuService loaiNguyenLieuService;
    @PostMapping("tao/loai-nguyen-lieu/{loaiNguyenLieuId}")
    public ResponseEntity<NguyenLieu> taoNguyenLieu(@RequestBody String nguyenLieu,
                                                    @PathVariable Integer loaiNguyenLieuId) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public Object deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        return loaiNguyenLieuService.getLoaiNguyenLieuById(loaiNguyenLieuId).map(loaiNguyenLieu -> {
            NguyenLieu nguyenLieu1 = gson.fromJson(nguyenLieu, NguyenLieu.class);
            nguyenLieu1.setLoaiNguyenLieu(loaiNguyenLieu);
            return new ResponseEntity<>(nguyenLieuService.save(nguyenLieu1), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
