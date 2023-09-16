package com.example.studentcourse.service;

import com.example.studentcourse.model.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long studentId);
}
