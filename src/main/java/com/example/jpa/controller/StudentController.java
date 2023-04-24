package com.example.jpa.controller;

import com.example.jpa.model.Classes;
import com.example.jpa.model.Student;
import com.example.jpa.service.ClassesService;
import com.example.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/class")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;

    public final List<Student> students = new ArrayList<>();

    @PostMapping("/{classId}/student/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student, @PathVariable Integer classId) {

        return classesService.getByid(classId).map(classes -> {

            int n = (int) classesService
                    .getAllStudentOfClass(classId)
                    .stream()
                    .filter(s -> s.getClasses().getId() == classId).count();
            if (n >= 20) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            student.setClasses(classes);
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
        }).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {

        Optional<Student> studentOptional = Optional.ofNullable(studentService.get(id));

        return studentOptional.map(student1 -> {
            student.setId(student1.getId());
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            studentService.delete(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{classId}/student/{id}/edit")
    public ResponseEntity<Student> UpdateClassOfStudent(@PathVariable Integer id, @PathVariable Integer classId) {

        Optional<Student> studentOptional = Optional.ofNullable(studentService.get(id));

        return studentOptional.map(student1 -> {

            int n = (int) classesService
                    .getAllStudentOfClass(classId)
                    .stream()
                    .filter(s -> s.getClasses().getId() == classId).count();
            if (n >= 20) {
                return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
            }
            student1.setClasses(classesService.getByid(classId).get());
            student1.setId(student1.getId());
            return new ResponseEntity<>(studentService.saveStudent(student1), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//    @GetMapping("/search")
//    public ResponseEntity<?> search(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.searchUser(name));
//    }

//    @GetMapping("/add-list-student")
//    public ResponseEntity<String> addStudents() {
//        studentService.addListStudent();
//        return ResponseEntity.ok("them thanh cong");
//    }

//    @GetMapping("/list/{id}")
//    public List<Student> getAllStudentOfClass(@PathVariable Integer id) {
//        return classesService.getAllStudentOfClass(id);
//    }
}
