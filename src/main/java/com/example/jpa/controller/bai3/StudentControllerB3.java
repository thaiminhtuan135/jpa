package com.example.jpa.controller.bai3;


import com.example.jpa.model.Student;
import com.example.jpa.model.bai3.Course;
import com.example.jpa.model.bai3.StudentB3;
import com.example.jpa.service.bai3.CourseService;
import com.example.jpa.service.bai3.StudentServiceB3;
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
@RequestMapping("/bai3/student")
public class StudentControllerB3 {
    @Autowired
    private StudentServiceB3 studentServiceB3;
    @Autowired
    private CourseService courseService;
    @PutMapping({"/{id}/course/{courseId}/edit"})
    private ResponseEntity<StudentB3> updateStudent(@RequestBody String student ,
                                                    @PathVariable Integer id,
                                                    @PathVariable Integer courseId) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public Object deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        return studentServiceB3.getStudentById(id).map(studentB3 -> {

            try {
                Course course = courseService.getCourseById(courseId).get();
                StudentB3 student1 = gson.fromJson(student, StudentB3.class);
                student1.setId(studentB3.getId());
                student1.setCourse(course);
                return new ResponseEntity<>(studentServiceB3.save(student1), HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<StudentB3>(HttpStatus.NOT_FOUND);
            }
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<?> findStudentByName(@RequestParam String name) {

        List<StudentB3> listStudent = studentServiceB3.getStudents()
                .stream()
                .filter(studentB3 -> studentB3.getName()
                .contains(name)).toList();

        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }
    @GetMapping("/getAllStudentByCourse")
    public ResponseEntity<?> findStudentByCourse(@RequestParam (name="nameCourse" ,required = false,defaultValue = "")String nameCourse ) {

//        List<Course> listCourses = courseService.getCourses().stream().filter(course -> course.getName().);
        List<StudentB3> listStudent = studentServiceB3.getStudents()
                .stream()
                .filter(studentB3 -> studentB3.getCourse().getName().contains(nameCourse)).toList();

        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

}
