package com.example.jpa.controller.bai3;

import com.example.jpa.model.Student;
import com.example.jpa.model.bai3.DayStudy;
import com.example.jpa.service.bai3.CourseService;
import com.example.jpa.service.bai3.DayStudyService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/bai3/course")
public class DayStudyController {
    @Autowired
    private DayStudyService dayStudyService;
    @Autowired
    private CourseService courseService;
    @PostMapping(value = "/{courseId}/dayStudy/create")
    public ResponseEntity<?> createStudent(@RequestBody String dayStudy, @PathVariable Integer courseId) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public Object deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        return courseService.getCourseById(courseId).map(course -> {

            DayStudy ds = gson.fromJson(dayStudy, DayStudy.class);
            ds.setCourse(course);
            return new ResponseEntity<>(dayStudyService.save(ds), HttpStatus.OK);
        }).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }
}
