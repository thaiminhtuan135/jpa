package com.example.jpa.controller.bai2;

import com.example.jpa.model.Student;
import com.example.jpa.model.bai2.Employee;
import com.example.jpa.model.bai2.Project;
import com.example.jpa.service.bai2.ProjectService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PutMapping("/{id}/edit")
    public ResponseEntity<Project> getProjectById(@RequestBody String project , @PathVariable int id) {
        Gson gson = new Gson();

        return projectService.getProjectById(id).map(project1 -> {
            Project pro = gson.fromJson(project, Project.class);
            pro.setId(project1.getId());

            return new ResponseEntity<>(projectService.save(pro), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
