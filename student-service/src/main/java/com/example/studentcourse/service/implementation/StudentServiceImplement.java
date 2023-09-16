package com.example.studentcourse.service.implementation;
import com.example.commonservice.dto.CourseDto;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.entity.Student;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        List<StudentDto> studentDtoList = new ArrayList<>();

        for (Student student : studentList) {
            CourseDto courseDto = webClient
                    .get()
                    .uri("{id}", student.getCourseId())
                    .retrieve()
                    .bodyToMono(CourseDto.class)
                    .block();

//            response.add(new StudentDto(
//                    st.getId(),
//                    st.getFirstName(),
//                    st.getLastName(),
//                    st.getEmail(),
//                    courseDto)
//            );

            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
            studentDto.setCourseDto(courseDto);

            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            CourseDto courseDto = webClient
                    .get()
                    .uri("{id}", student.get().getCourseId())
                    .retrieve()
                    .bodyToMono(CourseDto.class)
                    .block();

//                  return new StudentDto(
//                    student.get().getId(),
//                    student.get().getFirstName(),
//                    student.get().getLastName(),
//                    student.get().getEmail(),
//                    courseDto
//                  );

            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
            studentDto.setCourseDto(courseDto);

            return studentDto;
        }

       return null;
    }

}
