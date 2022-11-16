package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Course;
import com.koshailimited.springdatajpamapping.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courseList = courseRepository.findAll();

        System.out.println("courseList = " + courseList);
    }
    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder().firstName("Myhit").lastName("Kumar")
                .build();

        Course course = Course.builder().title("python").credit(3).teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPage = (Pageable) PageRequest.of(0,3);
    }
}