package com.example.courseservice.service.implementation;

import com.example.commonservice.dto.CourseDto;
import com.example.courseservice.model.entity.Course;
import com.example.courseservice.model.request.CourseRequest;
import com.example.courseservice.repository.CourseRepository;
import com.example.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImplement implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList: " + courseList);

        return courseList.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .toList();
    }

    @Override
    public CourseDto insertCourse(CourseRequest courseRequest) {
        Course course = modelMapper.map(courseRequest, Course.class);
        Course saveCourse = courseRepository.save(course);
        return modelMapper.map(saveCourse, CourseDto.class);
    }

    @Override
    public CourseDto getCourseById(Long courseId) {
        Optional<Course> findCourse = courseRepository.findById(courseId);
        System.out.println("findCourse: " + findCourse);

        if(findCourse.isPresent()) {
            Course course = findCourse.get();
            return modelMapper.map(course, CourseDto.class);
        }
        return null;
    }

    @Override
    public CourseDto updateCourseById(Long courseId, CourseRequest courseRequest) {
        Optional<Course> findCourse = courseRepository.findById(courseId);
        if(findCourse.isPresent()) {
            Course course = findCourse.get();
            modelMapper.map(courseRequest, course);
            Course saveCourse = courseRepository.save(course);
            return modelMapper.map(saveCourse, CourseDto.class);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
        return null;
    }


}
