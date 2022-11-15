package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Course;
import com.koshailimited.springdatajpamapping.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder().title("Computer Programming").credit(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

}