package com.example.courseapp.controller;

import com.example.courseapp.entity.Course;
import com.example.courseapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course saved = service.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Optional<Course> course = service.getCourseById(id);

        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Optional<Course> existing = service.getCourseById(id);

        if (existing.isPresent()) {
            course.setCourseId(id);
            return ResponseEntity.ok(service.updateCourse(course));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        Optional<Course> course = service.getCourseById(id);

        if (course.isPresent()) {
            service.deleteCourse(id);
            return ResponseEntity.ok("Course deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {
        List<Course> courses = service.searchByTitle(title);

        if (courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No courses found");
        }

        return ResponseEntity.ok(courses);
    }
}