package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Guardian;
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
                .lastName("islam")
//                .guardianName("Abu Taher").guardianEmail("taher@gmail.com")
//                .guardianMobile("023723572")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder().name("Ziaul").email("zia@gmail.com").mobile("235324434").build();

        Student student = Student.builder().firstName("Arshil").lastName("Azeem").emailId("arshil@azem.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> studentList = studentRepository.findByFirstName("toriql");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void  printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("a");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Abu Taher");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentBasedOnGuardianNameContaining(){
        List<Student> studentList = studentRepository.findByGuardianNameContaining("Abu");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printGetStudentByEmailAddress(){
        String s = studentRepository.getStudentByEmailAddress("toriqultonu22@gmail.com", "toriqul");
        System.out.println("student = " + s);
    }
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentEmailAddressNative("toriqultonu22@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentByEmailAddressNativeParamName(){
        Student student = studentRepository.getStudentEmailAddressNativeNameParam("toriqultonu22@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmail(){
        studentRepository.updateStudentNameByEmail("toriqultonu22","toriqultonu22@gmail.com");
    }
}