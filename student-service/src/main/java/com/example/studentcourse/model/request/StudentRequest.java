package com.example.studentcourse.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;

}
