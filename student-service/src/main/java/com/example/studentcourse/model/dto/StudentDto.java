package com.example.studentcourse.model.dto;

import com.example.commonservice.dto.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private CourseDto courseDto;

}
