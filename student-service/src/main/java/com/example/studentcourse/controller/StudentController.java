package com.example.studentcourse.controller;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        return ResponseEntity.ok().body(studentDtoList);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long studentId) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok().body(studentDto);
    }

}
