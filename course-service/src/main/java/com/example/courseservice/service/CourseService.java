package com.example.courseservice.service;

import com.example.commonservice.dto.CourseDto;
import com.example.courseservice.model.request.CourseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDto> getAllCourses();

    CourseDto insertCourse(CourseRequest courseRequest);

    CourseDto getCourseById(Long courseId);

    CourseDto updateCourseById(Long courseId, CourseRequest courseRequest);

    ResponseEntity<?> deleteCourseById(Long courseId);
}
