package com.nurbergenovv.lab5.controller;

import com.nurbergenovv.lab5.entity.Course;
import com.nurbergenovv.lab5.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(
                courseService.getAllCourses(), HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course course) {
        courseService.update(id, course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Course c = courseService.getCourseById(id);
        courseService.deleteCourse(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}