package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameIsNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByGuardianNameContaining(String guardianName);
    @Query("select s.guardian.name from Student s where s.emailId = ?1 and s.firstName= ?2")
    public String getStudentByEmailAddress(String email, String firstName);
}
