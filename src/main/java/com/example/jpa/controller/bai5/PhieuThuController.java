package com.example.jpa.controller.bai5;


import com.example.jpa.model.bai4.Food;
import com.example.jpa.model.bai5.PhieuThu;
import com.example.jpa.service.bai5.PhieuThuService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/phieuthu")
public class PhieuThuController {
    @Autowired
    private PhieuThuService phieuThuService;

    @PostMapping("/tao")
    public ResponseEntity<PhieuThu> createFood(@RequestBody String phieuthu) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public Object deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        PhieuThu phieuThu = gson.fromJson(phieuthu, PhieuThu.class);
        return new ResponseEntity<PhieuThu>(phieuThuService.save(phieuThu), HttpStatus.OK);
    }


}
