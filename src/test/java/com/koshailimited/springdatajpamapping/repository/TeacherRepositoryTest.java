package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Course;
import com.koshailimited.springdatajpamapping.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course stats = Course.builder().title("Stats").credit(3)
                .build();
        Course db = Course.builder().title("db").credit(3)
                .build();

        Teacher teacher = Teacher.builder().firstName("Furuk").lastName("Zaman")//.courseList(List.of(stats,db))
                .build();

        teacherRepository.save(teacher);
    }
}