package com.example.courseapp.repository;

import com.example.courseapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitleContaining(String title);
}