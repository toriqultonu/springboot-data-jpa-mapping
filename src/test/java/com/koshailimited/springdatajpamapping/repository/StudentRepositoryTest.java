package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("toriqultonu25@gmail.com").firstName("toriql")
                .lastName("islam").guardianName("Abu Taher").guardianEmail("taher@gmail.com")
                .guardianMobile("023723572")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }
}