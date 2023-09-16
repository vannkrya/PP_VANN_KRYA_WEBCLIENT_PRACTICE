package com.example.courseservice.controller;

import com.example.commonservice.dto.CourseDto;
import com.example.courseservice.model.request.CourseRequest;
import com.example.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        List<CourseDto> courseDtoList = courseService.getAllCourses();
        return ResponseEntity.ok().body(courseDtoList);
    }

    @PostMapping
    public ResponseEntity<CourseDto> insertCourse(@RequestBody CourseRequest courseRequest) {
        CourseDto courseDto = courseService.insertCourse(courseRequest);
        return ResponseEntity.ok().body(courseDto);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId) {
        CourseDto courseDto = courseService.getCourseById(courseId);
        return ResponseEntity.ok().body(courseDto);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDto> updateCourseById(
            @PathVariable Long courseId,
            @RequestBody CourseRequest courseRequest
    ) {
        CourseDto courseDto = courseService.updateCourseById(courseId, courseRequest);
        return ResponseEntity.ok().body(courseDto);
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long courseId) {
        ResponseEntity<?> course = courseService.deleteCourseById(courseId);
        return ResponseEntity.ok().body(course);
    }


}
