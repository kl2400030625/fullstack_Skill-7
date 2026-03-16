package com.example.courseapp.service;

import com.example.courseapp.entity.Course;
import com.example.courseapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(@NonNull Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return repo.findById(id);
    }

    public Course updateCourse(@NonNull Course course) {
        return repo.save(course);
    }

    public void deleteCourse(int id) {
        repo.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }
}