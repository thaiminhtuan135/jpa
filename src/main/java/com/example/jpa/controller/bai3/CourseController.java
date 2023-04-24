package com.example.jpa.controller.bai3;

import com.example.jpa.model.Student;
import com.example.jpa.model.bai2.Employee;
import com.example.jpa.model.bai3.Course;
import com.example.jpa.model.bai3.StudentB3;
import com.example.jpa.service.bai3.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/bai3/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Integer id) {
        try {
            Course course = courseService.getCourseById(id).get();
            courseService.delete(id);
            return new ResponseEntity<Course>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/revenue")
    public ResponseEntity<?> revenue() {
        List<Course> courses = courseService.getCourses();

//        Map<Course, Integer> map = new HashMap<>();
//        courses.forEach(course -> {
//            Integer revenue = course.getStudentList().size() * course.getFee();
//
//            map.put(course, revenue);
//        });
//        Map<Course, Integer> map = courses.stream()
//                .collect(Collectors.groupingBy(course -> course,
//                        Collectors.summingInt(value -> value.getStudentList().size())));


//        Map<Integer, List<StudentB3>> map = courses
//                .stream()
//                .collect(Collectors.groupingBy(course -> course.getStatTime().getMonth()+1
//                , Collectors.flatMapping(course -> course.getStudentList().stream(),Collectors.toList())));

        Map<Integer, Integer> map = courses
                .stream()
                .collect(Collectors.groupingBy(course -> course.getStatTime().getMonth()+1
                        , Collectors.summingInt(value -> value.getFee()*value.getStudentList().size())));


        return new ResponseEntity<>(map, HttpStatus.OK);
    }
 }
